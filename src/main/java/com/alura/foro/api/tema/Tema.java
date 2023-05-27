package com.alura.foro.api.tema;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity( name = "tema" )
@Table ( name = "temas" )
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tema {


  
  
  @Id
  @GeneratedValue ( strategy = GenerationType.IDENTITY )
  private Long id;
  private String titulo;
  private String mensaje;
  private String autor;
  private String curso;
  private String estado = "activo";
  @GeneratedValue
  private String fecha_creacion = getDate();

  static String getDate (){
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return date.format(new Date());
  }


  public Tema( DTOcreateTema data ) {
    this.titulo = data.titulo();
    this.mensaje = data.mensaje();
    this.autor = data.autor();
    this.curso = data.curso();
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
    result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
    result = prime * result + ((autor == null) ? 0 : autor.hashCode());
    result = prime * result + ((curso == null) ? 0 : curso.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Tema other = (Tema) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (titulo == null) {
      if (other.titulo != null)
        return false;
    } else if (!titulo.equals(other.titulo))
      return false;
    if (mensaje == null) {
      if (other.mensaje != null)
        return false;
    } else if (!mensaje.equals(other.mensaje))
      return false;
    if (autor == null) {
      if (other.autor != null)
        return false;
    } else if (!autor.equals(other.autor))
      return false;
    if (curso == null) {
      if (other.curso != null)
        return false;
    } else if (!curso.equals(other.curso))
      return false;
    return true;
  }


  public void actualizar (@Valid DTOcreateTema data ) {
    this.titulo = data.titulo();
    this.mensaje = data.mensaje();
    this.autor = data.autor();
    this.curso = data.curso();
  }


  public void eliminar(  ) {
    this.estado = "resuelto";
  }



}

