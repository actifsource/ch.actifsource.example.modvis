package ch.actifsource.example.modvis.generic.model.javamodel;

import ch.actifsource.util.collection.IMultiMapOrdered;
import ch.actifsource.core.dynamic.*;

@edu.umd.cs.findbugs.annotations.SuppressWarnings("EQ_DOESNT_OVERRIDE_EQUALS")
public class Statemachine extends DynamicResource implements IStatemachine {

  public static final ch.actifsource.core.dynamic.IDynamicResource.IFactory<IStatemachine> FACTORY = new ch.actifsource.core.dynamic.IDynamicResource.IFactory<IStatemachine>() {
    
    @Override
    public IStatemachine create() {
      return new Statemachine();
    }
    
    @Override
    public IStatemachine create(IDynamicResourceRepository resourceRepository, ch.actifsource.core.Resource resource) {
      return new Statemachine(resourceRepository, resource);
    }
  
  };

  public Statemachine() {
    super(IStatemachine.TYPE_ID);
  }
  
  public Statemachine(IDynamicResourceRepository resourceRepository, ch.actifsource.core.Resource resource) {
    super(resourceRepository, resource, IStatemachine.TYPE_ID);
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
  public java.util.List<? extends ch.actifsource.diagram.javamodel.IDomainDiagram> selectDiagram() {
    return _getList(ch.actifsource.diagram.javamodel.IDomainDiagram.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Statemachine_diagram);
  }

  public Statemachine setDiagram(java.util.List<? extends ch.actifsource.diagram.javamodel.IDomainDiagram> diagram) {
    _setList(ch.actifsource.example.modvis.generic.model.ModelPackage.Statemachine_diagram, diagram);
    return this;
  }
    
  @Override
  public java.util.List<? extends ch.actifsource.example.modvis.generic.model.javamodel.IState> selectState() {
    return _getList(ch.actifsource.example.modvis.generic.model.javamodel.IState.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Statemachine_state);
  }

  public Statemachine setState(java.util.List<? extends ch.actifsource.example.modvis.generic.model.javamodel.IState> state) {
    _setList(ch.actifsource.example.modvis.generic.model.ModelPackage.Statemachine_state, state);
    return this;
  }
    
  @Override
  public ch.actifsource.core.javamodel.IClass selectTypeOf() {
    return _getSingle(ch.actifsource.core.javamodel.IClass.class, ch.actifsource.core.CorePackage.Resource_typeOf);
  }

  public Statemachine setTypeOf(ch.actifsource.core.javamodel.IClass typeOf) {
    _setSingle(ch.actifsource.core.CorePackage.Resource_typeOf, typeOf);
    return this;
  }
    
  // accept property value visitor
  @Override
  public void accept(IPropertyValueVisitor visitor) {
    // attributes
    _acceptSingleAttribute(java.lang.String.class, ch.actifsource.core.CorePackage.NamedResource_name, visitor);
    // relations
    _acceptList(ch.actifsource.diagram.javamodel.IDomainDiagram.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Statemachine_diagram, visitor);
    _acceptList(ch.actifsource.example.modvis.generic.model.javamodel.IState.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Statemachine_state, visitor);
    _acceptSingle(ch.actifsource.core.javamodel.IClass.class, ch.actifsource.core.CorePackage.Resource_typeOf, visitor);
  }

  // toMeRelations
  
  public static ch.actifsource.example.modvis.generic.model.javamodel.IStatemachine selectToMeState(ch.actifsource.example.modvis.generic.model.javamodel.IState object) {
    return _getToMeSingle(object.getRepository(), ch.actifsource.example.modvis.generic.model.javamodel.IStatemachine.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Statemachine_state, object.getResource());
  }
  
  public static ch.actifsource.example.modvis.generic.model.javamodel.IStatemachine selectToMeDiagram(ch.actifsource.diagram.javamodel.IDomainDiagram object) {
    return _getToMeSingle(object.getRepository(), ch.actifsource.example.modvis.generic.model.javamodel.IStatemachine.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Statemachine_diagram, object.getResource());
  }
  
}
/* Actifsource ID=[4d723cb5-db37-11de-82b8-17be2e034a3b,e5aaede8-894f-11ee-bd0f-cd4c7b5a6846,94PkhaVR6QQjO2FxQpJ6tw6LFJE=] */
