package com.example.Spendy.repositorios;

import com.example.Spendy.modelos.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGastoRepositorio extends JpaRepository<Gasto, Long> {
    // Proporciona los métodos para persistir los consumos o gastos financieros
}