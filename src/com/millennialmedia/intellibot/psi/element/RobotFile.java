package com.millennialmedia.intellibot.psi.element;

import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * @author Stephen Abrams
 */
public interface RobotFile extends PsiFile {

    /**
     * @return locally defined keywords
     */
    @NotNull
    Collection<DefinedKeyword> getDefinedKeywords();

    /**
     * @return all files that contain references to invoked keywords
     */
    @NotNull
    Collection<PsiFile> getFilesFromInvokedKeywords();

    /**
     * Gets all the imported keyword files that are considered in scope for this file.  This
     * includes python libraries and robot resource files.
     *
     * @return a collection of keyword files that this files knows about.
     */
    @NotNull
    Collection<KeywordFile> getImportedFiles(boolean includeTransitive);

    @NotNull
    Collection<DefinedVariable> getDefinedVariables();
    
    void importsChanged();
}
