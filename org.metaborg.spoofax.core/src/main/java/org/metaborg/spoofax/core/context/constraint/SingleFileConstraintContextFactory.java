package org.metaborg.spoofax.core.context.constraint;

import org.metaborg.core.context.ContextIdentifier;
import org.metaborg.core.context.IContextFactory;
import org.metaborg.spoofax.core.context.constraint.IConstraintContext.Mode;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class SingleFileConstraintContextFactory implements IContextFactory {

    public static final String name = "constraint-singlefile";

    private final Injector injector;

    @Inject public SingleFileConstraintContextFactory(Injector injector) {
        this.injector = injector;
    }

    @Override public IConstraintContext create(ContextIdentifier identifier) {
        return new ConstraintContext(Mode.SINGLE_FILE, injector, identifier);
    }

    @Override public TemporaryConstraintContext createTemporary(ContextIdentifier identifier) {
        return new TemporaryConstraintContext(create(identifier));
    }

}