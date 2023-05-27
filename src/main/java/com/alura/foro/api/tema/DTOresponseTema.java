package com.alura.foro.api.tema;


public record DTOresponseTema(
  Long id,
  String titulo,
  String mensaje,
  String autor,
  String curso,
  String estado,
  String fecha_creacion
 ) {
  

  public DTOresponseTema( Tema tema ) {
    this( tema.getId(), tema.getTitulo(), tema.getMensaje(), tema.getAutor(), tema.getCurso(), tema.getEstado(), tema.getFecha_creacion() );
  }

  
}
