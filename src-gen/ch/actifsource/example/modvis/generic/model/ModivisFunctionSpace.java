package ch.actifsource.example.modvis.generic.model;

import ch.actifsource.util.Assert;
import java.util.List;
import ch.actifsource.core.dynamic.DynamicResourceUtil;
import ch.actifsource.core.dynamic.IDynamicResourceExtension;
import ch.actifsource.core.dynamic.IDynamicResourceExtensionJavaImpl;
import ch.actifsource.core.selector.typesystem.JavaFunctionUtil;

/* Begin Protected Region [[55ef53ca-8954-11ee-bd0f-cd4c7b5a6846,imports]] */

/* End Protected Region   [[55ef53ca-8954-11ee-bd0f-cd4c7b5a6846,imports]] */

public class ModivisFunctionSpace {

  /* Begin Protected Region [[55ef53ca-8954-11ee-bd0f-cd4c7b5a6846]] */
  
  /* End Protected Region   [[55ef53ca-8954-11ee-bd0f-cd4c7b5a6846]] */


  public static interface IResourceFunctions extends IDynamicResourceExtension {

    @IDynamicResourceExtension.MethodId("5f63d442-8954-11ee-bd0f-cd4c7b5a6846")
    public java.lang.Integer getElementId(final ch.actifsource.example.modvis.generic.model.javamodel.IStatemachine statemachine);

    @IDynamicResourceExtension.MethodId("60dbb542-8959-11ee-bd0f-cd4c7b5a6846")
    public java.lang.Integer getElementInitState(final ch.actifsource.example.modvis.generic.model.javamodel.IStatemachine statemachine);

  }
  
  public static interface IResourceFunctionsImpl extends IDynamicResourceExtensionJavaImpl {
    
  }
  
  public static class ResourceFunctionsImpl implements IResourceFunctionsImpl {

    public static final IResourceFunctionsImpl INSTANCE = new ResourceFunctionsImpl();

    private ResourceFunctionsImpl() {}

  }
  
  public static class ResourceFunctions {

    private ResourceFunctions() {}

  }

}

/* Actifsource ID=[5349246f-db37-11de-82b8-17be2e034a3b,55ef53ca-8954-11ee-bd0f-cd4c7b5a6846,moY7S4I724wnlewHXbs5Hy1b35c=] */
