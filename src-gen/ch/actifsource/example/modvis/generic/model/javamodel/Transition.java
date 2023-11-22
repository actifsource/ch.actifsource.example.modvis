package ch.actifsource.example.modvis.generic.model.javamodel;

import ch.actifsource.util.collection.IMultiMapOrdered;
import ch.actifsource.core.dynamic.*;

@edu.umd.cs.findbugs.annotations.SuppressWarnings("EQ_DOESNT_OVERRIDE_EQUALS")
public class Transition extends DynamicResource implements ITransition {

  public static final ch.actifsource.core.dynamic.IDynamicResource.IFactory<ITransition> FACTORY = new ch.actifsource.core.dynamic.IDynamicResource.IFactory<ITransition>() {
    
    @Override
    public ITransition create() {
      return new Transition();
    }
    
    @Override
    public ITransition create(IDynamicResourceRepository resourceRepository, ch.actifsource.core.Resource resource) {
      return new Transition(resourceRepository, resource);
    }
  
  };

  public Transition() {
    super(ITransition.TYPE_ID);
  }
  
  public Transition(IDynamicResourceRepository resourceRepository, ch.actifsource.core.Resource resource) {
    super(resourceRepository, resource, ITransition.TYPE_ID);
  }

  // relations
  
  @Override
  public ch.actifsource.example.modvis.generic.model.javamodel.IState selectTargetState() {
    return _getSingle(ch.actifsource.example.modvis.generic.model.javamodel.IState.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Transition_targetState);
  }

  public Transition setTargetState(ch.actifsource.example.modvis.generic.model.javamodel.IState targetState) {
    _setSingle(ch.actifsource.example.modvis.generic.model.ModelPackage.Transition_targetState, targetState);
    return this;
  }
    
  @Override
  public ch.actifsource.core.javamodel.IClass selectTypeOf() {
    return _getSingle(ch.actifsource.core.javamodel.IClass.class, ch.actifsource.core.CorePackage.Resource_typeOf);
  }

  public Transition setTypeOf(ch.actifsource.core.javamodel.IClass typeOf) {
    _setSingle(ch.actifsource.core.CorePackage.Resource_typeOf, typeOf);
    return this;
  }
    
  // accept property value visitor
  @Override
  public void accept(IPropertyValueVisitor visitor) {
    // relations
    _acceptSingle(ch.actifsource.example.modvis.generic.model.javamodel.IState.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Transition_targetState, visitor);
    _acceptSingle(ch.actifsource.core.javamodel.IClass.class, ch.actifsource.core.CorePackage.Resource_typeOf, visitor);
  }

  // toMeRelations
  
  public static ch.actifsource.example.modvis.generic.model.javamodel.ITransition selectToMeTargetState(ch.actifsource.example.modvis.generic.model.javamodel.IState object) {
    return _getToMeSingle(object.getRepository(), ch.actifsource.example.modvis.generic.model.javamodel.ITransition.class, ch.actifsource.example.modvis.generic.model.ModelPackage.Transition_targetState, object.getResource());
  }
  
}
/* Actifsource ID=[4d723cb5-db37-11de-82b8-17be2e034a3b,f62f4a00-894f-11ee-bd0f-cd4c7b5a6846,UR6PHebKGJqZArrQlMbpEDkK3cU=] */
