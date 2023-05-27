package com.alura.foro.api.tema;


import jakarta.validation.constraints.NotBlank;

public record DTOcreateTema(
  @NotBlank
  String titulo,
  @NotBlank
  String mensaje,
  @NotBlank
  String autor,
  @NotBlank
  String curso,
  String fecha_creacion
) {

  public DTOcreateTema(Tema tema) {
    this( tema.getTitulo(), tema.getMensaje(), tema.getAutor(), tema.getCurso(), tema.getFecha_creacion() );
  }
  
}