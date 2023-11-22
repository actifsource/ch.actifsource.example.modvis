package ch.actifsource.example.modvis.generic.model.javamodel;

import ch.actifsource.util.collection.IMultiMapOrdered;

public interface IState extends ch.actifsource.core.javamodel.INamedResource {

  public static final ch.actifsource.core.INode TYPE_ID = new ch.actifsource.core.Resource("e7d85447-894f-11ee-bd0f-cd4c7b5a6846");
  
  // relations
  
  public java.util.List<? extends ch.actifsource.example.modvis.generic.model.javamodel.ITransition> selectTransition();
  
}

/* Actifsource ID=[3ca9f967-db37-11de-82b8-17be2e034a3b,e7d85447-894f-11ee-bd0f-cd4c7b5a6846,2/V6OJSEzMd0wx1oumUFZzMehmg=] */
