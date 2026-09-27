package com.krakedev.parqueadero.controladores;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.parqueadero.modelo.TicketCobro;
import com.krakedev.parqueadero.servicios.ServicioCobro;

@RestController
@RequestMapping("/{cobros}")
public class CobroController {

    private final ServicioCobro servicioCobro;

    public CobroController(ServicioCobro servicioCobro) {
        this.servicioCobro = servicioCobro;
    }

    @PostMapping("/procesar/{placa}/{horas}")
    public ResponseEntity<TicketCobro> procesarSalida(@PathVariable String placa, @PathVariable int horas) {
        TicketCobro ticket = servicioCobro.procesarSalida(placa, horas);

        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{total}")
    public double calcularTotalRecaudado() {
        return servicioCobro.calcularTotalRecaudado();
    }

    @GetMapping("/{historial}")
    public ArrayList<TicketCobro> listarTickets() {
        return servicioCobro.listarTickets();
    }
}
