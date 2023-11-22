package ch.actifsource.example.modvis.generic.model.javamodel;

import ch.actifsource.util.collection.IMultiMapOrdered;

public interface ITransition extends ch.actifsource.core.javamodel.IResource {

  public static final ch.actifsource.core.INode TYPE_ID = new ch.actifsource.core.Resource("f62f4a00-894f-11ee-bd0f-cd4c7b5a6846");
  
  // relations
  
  public ch.actifsource.example.modvis.generic.model.javamodel.IState selectTargetState();
  
}

/* Actifsource ID=[3ca9f967-db37-11de-82b8-17be2e034a3b,f62f4a00-894f-11ee-bd0f-cd4c7b5a6846,T6rdOD4sIZ/KWdCEc4MC8WQItns=] */
