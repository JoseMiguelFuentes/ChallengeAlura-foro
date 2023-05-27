package com.alura.foro.api.tema;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;


public interface TemaRepository extends JpaRepository<Tema,Long> {

  
  // UserDetails findByTitulo( String nombre );

  // @Query("SELECT t FROM tema t WHERE t.status = 'activo'")
  Page<Tema> findByEstado(  String activo, Pageable pages );

}
