package com.alura.foro.api.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.api.tema.DTOcreateTema;
import com.alura.foro.api.tema.DTOresponseTema;
import com.alura.foro.api.tema.Tema;
import com.alura.foro.api.tema.TemaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping( path = "/topicos" )  
public class TemaController {

  
  private TemaRepository repository;
  public TemaController ( TemaRepository repository ){
    this.repository = repository;
  }
  
  @PostMapping
  @Transactional
  public ResponseEntity<DTOresponseTema> crearTema( @RequestBody @Valid DTOcreateTema data ){
    System.out.println( data.titulo() +" "+ data.mensaje() );

    Tema tema = new Tema( data );
    repository.saveAndFlush( tema );
    return ResponseEntity.ok().body( new DTOresponseTema ( tema ) );
  }

  @GetMapping
  public Page<DTOresponseTema> listarTemas (@PageableDefault(size = 10, sort = "titulo" ) Pageable pages ){
    return repository.findByEstado( "activo", pages ).map( DTOresponseTema::new);
  }

  @GetMapping( "/{id}" )
  @Transactional
  public ResponseEntity<ResponseEntity<DTOresponseTema>> temaDetail ( @PathVariable Long id ){
    Tema tema = repository.getReferenceById( id );
    System.out.println(tema);
    ResponseEntity<DTOresponseTema> body = ResponseEntity.ok().body( new DTOresponseTema ( tema ) );
    return ResponseEntity.ok( body );
  }

  @PostMapping( "/{id}" )
  @Transactional
  public ResponseEntity<DTOresponseTema> actualizarTema( @RequestBody @Valid DTOcreateTema data,  @PathVariable Long id ){
    Tema tema = repository.getReferenceById( id );
    tema.actualizar( data );
    return ResponseEntity.ok().body( new DTOresponseTema ( tema ) );
  }

  @DeleteMapping( "/{id}" )
  @Transactional
  public ResponseEntity<Page<Tema>> eliminarTema( @PathVariable Long id ){
    Tema tema = repository.getReferenceById( id );
    tema.eliminar( );
    return ResponseEntity.noContent().build();
  }


}
