package ch.actifsource.example.modvis.generic.model.javamodel;

import ch.actifsource.util.collection.IMultiMapOrdered;
import ch.actifsource.core.dynamic.*;

@edu.umd.cs.findbugs.annotations.SuppressWarnings("EQ_DOESNT_OVERRIDE_EQUALS")
public class State extends DynamicResource implements IState {

  public static final ch.actifsource.core.dynamic.IDynamicResource.IFactory<IState> FACTORY = new ch.actifsource.core.dynamic.IDynamicResource.IFactory<IState>() {
    
    @Override
    public IState create() {
      return new State();
    }
    
    @Override
    public IState create(IDynamicResourceRepository resourceRepository, ch.actifsource.core.Resource resource) {
      return new State(resourceRepository, resource);
    }
  
  };

  public State() {
    super(IState.TYPE_ID);
  }
  
  public State(IDynamicResourceRepository resourceRepository, ch.actifsource.core.Resource resource) {
    super(resourceRepository, resource, IState.TYPE_ID);
  }

  // attributes
  
  @Override
  public java.lang.String selectName() {
    return _getSingleAttribute(java.lang.String.class, ch.actifsource.core.CorePackage.NamedResource_name);
  }
    
  public void setName(java.lang.String name) {
     _setSingleAttribute(ch.actifsource.core.CorePackage.NamedResource_name, name);
  }

  // relations
  
  @Override
  public java.util.List<? extends ch.actifsource.example.modvis.generic.model.javamodel.ITransition> selectTransition() {
    return _getList(ch.actifsource.example.modvis.generic.model.javamodel.ITransition.class, ch.actifsource.example.modvis.generic.model.ModelPackage.State_transition);
  }

  public State setTransition(java.util.List<? extends ch.actifsource.example.modvis.generic.model.javamodel.ITransition> transition) {
    _setList(ch.actifsource.example.modvis.generic.model.ModelPackage.State_transition, transition);
    return this;
  }
    
  @Override
  public ch.actifsource.core.javamodel.IClass selectTypeOf() {
    return _getSingle(ch.actifsource.core.javamodel.IClass.class, ch.actifsource.core.CorePackage.Resource_typeOf);
  }

  public State setTypeOf(ch.actifsource.core.javamodel.IClass typeOf) {
    _setSingle(ch.actifsource.core.CorePackage.Resource_typeOf, typeOf);
    return this;
  }
    
  // accept property value visitor
  @Override
  public void accept(IPropertyValueVisitor visitor) {
    // attributes
    _acceptSingleAttribute(java.lang.String.class, ch.actifsource.core.CorePackage.NamedResource_name, visitor);
    // relations
    _acceptList(ch.actifsource.example.modvis.generic.model.javamodel.ITransition.class, ch.actifsource.example.modvis.generic.model.ModelPackage.State_transition, visitor);
    _acceptSingle(ch.actifsource.core.javamodel.IClass.class, ch.actifsource.core.CorePackage.Resource_typeOf, visitor);
  }

  // toMeRelations
  
  public static ch.actifsource.example.modvis.generic.model.javamodel.IState selectToMeTransition(ch.actifsource.example.modvis.generic.model.javamodel.ITransition object) {
    return _getToMeSingle(object.getRepository(), ch.actifsource.example.modvis.generic.model.javamodel.IState.class, ch.actifsource.example.modvis.generic.model.ModelPackage.State_transition, object.getResource());
  }
  
}
/* Actifsource ID=[4d723cb5-db37-11de-82b8-17be2e034a3b,e7d85447-894f-11ee-bd0f-cd4c7b5a6846,733+1sPIL2QDA5fPAkEEXFF4njg=] */
