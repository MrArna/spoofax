package org.metaborg.spoofax.core.build;

import org.metaborg.core.analysis.IAnalysisService;
import org.metaborg.core.build.Builder;
import org.metaborg.core.build.processing.analyze.IAnalysisResultUpdater;
import org.metaborg.core.build.processing.parse.IParseResultUpdater;
import org.metaborg.core.context.IContextService;
import org.metaborg.core.language.ILanguageIdentifierService;
import org.metaborg.core.language.dialect.IDialectProcessor;
import org.metaborg.core.language.dialect.IDialectService;
import org.metaborg.core.source.ISourceTextService;
import org.metaborg.core.syntax.ISyntaxService;
import org.metaborg.core.transform.ITransformer;
import org.spoofax.interpreter.terms.IStrategoTerm;

import com.google.inject.Inject;

/**
 * Typedef class for {@link Builder} with {@link IStrategoTerm}.
 */
public class SpoofaxBuilder extends Builder<IStrategoTerm, IStrategoTerm, IStrategoTerm> implements ISpoofaxBuilder {
    @Inject public SpoofaxBuilder(ILanguageIdentifierService languageIdentifier, IDialectService dialectService,
        IDialectProcessor dialectProcessor, IContextService contextService, ISourceTextService sourceTextService,
        ISyntaxService<IStrategoTerm> syntaxService, IAnalysisService<IStrategoTerm, IStrategoTerm> analyzer,
        ITransformer<IStrategoTerm, IStrategoTerm, IStrategoTerm> transformer,
        IParseResultUpdater<IStrategoTerm> parseResultProcessor,
        IAnalysisResultUpdater<IStrategoTerm, IStrategoTerm> analysisResultProcessor) {
        super(languageIdentifier, dialectService, dialectProcessor, contextService, sourceTextService, syntaxService,
            analyzer, transformer, parseResultProcessor, analysisResultProcessor);
    }
}
