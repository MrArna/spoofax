package org.metaborg.spoofax.core.stratego.primitive;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.vfs2.FileObject;
import org.metaborg.core.context.IContext;
import org.metaborg.core.language.ILanguageComponent;
import org.metaborg.core.resource.IResourceService;

import com.google.common.collect.Streams;
import com.google.inject.Inject;

public class LanguageResourcesPrimitive extends AResourcesPrimitive {

    @Inject public LanguageResourcesPrimitive(IResourceService resourceService) {
        super("language_resources", resourceService);
    }

    @Override protected List<FileObject> locations(IContext context) {
        return Streams.stream(context.language().components()).map(ILanguageComponent::location)
                .collect(Collectors.toList());
    }

}