package com.example.msdocumentodetesis.service;


import com.example.msdocumentodetesis.entity.TesisDocumento;
import com.example.msdocumentodetesis.repository.TesisDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class TesisDocumentoService {

    @Autowired
    private TesisDocumentoRepository tesisDocumentoRepository;

    private final String uploadDir = "uploads/";

    public TesisDocumento saveFile(MultipartFile file) throws IOException {
        // Verificar si el archivo ya existe
        String fileName = file.getOriginalFilename();
        Optional<TesisDocumento> existingDocument = tesisDocumentoRepository.findByNombreDocumento(fileName);
        if (existingDocument.isPresent()) {
            throw new IllegalArgumentException("El archivo ya existe en la base de datos");
        }

        // Crear el directorio de carga si no existe
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);


        TesisDocumento tesisDocumento = new TesisDocumento();
        tesisDocumento.setNombreDocumento(fileName);
        tesisDocumento.setRutaArchivo(filePath.toString());
        tesisDocumento.setTipoArchivo(file.getContentType());

        return tesisDocumentoRepository.save(tesisDocumento);
    }

    public TesisDocumento tomarDocumento(Long idDocumento) {
        return tesisDocumentoRepository.findById(idDocumento).orElse(null);
    }

    public List<TesisDocumento> listardocumento() {
        return tesisDocumentoRepository.findAll();
    }
}