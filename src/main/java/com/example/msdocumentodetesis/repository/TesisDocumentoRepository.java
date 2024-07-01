package com.example.msdocumentodetesis.repository;


import com.example.msdocumentodetesis.entity.TesisDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TesisDocumentoRepository extends JpaRepository<TesisDocumento, Long> {
    Optional<TesisDocumento> findByNombreDocumento(String nombreDocumento);
}