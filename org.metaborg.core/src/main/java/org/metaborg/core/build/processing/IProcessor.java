package org.metaborg.core.build.processing;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSelector;
import org.metaborg.core.build.BuildInput;
import org.metaborg.core.build.IBuildOutput;
import org.metaborg.core.language.LanguageChange;

public interface IProcessor<P, A, T> {
    public abstract ITask<IBuildOutput<P, A, T>> build(BuildInput input);

    public abstract ITask<?> clean(FileObject location, FileSelector excludeSelector);

    public abstract ITask<?> languageChange(LanguageChange change);
}