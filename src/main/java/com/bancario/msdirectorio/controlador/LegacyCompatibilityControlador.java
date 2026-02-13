package com.bancario.msdirectorio.controlador;

import com.bancario.msdirectorio.dto.InstitucionDTO;
import com.bancario.msdirectorio.servicio.DirectorioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador para mantener compatibilidad con rutas legacy requeridas por el
 * APIM.
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "Compatibilidad Legacy", description = "Rutas de compatibilidad para integraciones antiguas o APIM")
public class LegacyCompatibilityControlador {

    private final DirectorioServicio directorioServicio;

    /**
     * GET /api/v1/red/bancos
     * Alias de compatibilidad para APIM que redirige lógicamente a
     * /api/v1/instituciones.
     */
    @GetMapping("/api/v1/red/bancos")
    @Operation(summary = "Listar Bancos (Legacy Alias)", description = "Alias para /api/v1/instituciones")
    public ResponseEntity<List<InstitucionDTO>> listarBancosAlias() {
        return ResponseEntity.ok(directorioServicio.listarTodas());
    }
}
