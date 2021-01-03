package com.ckh.jim.util;

import io.noties.prism4j.annotations.PrismBundle;

@PrismBundle(
        include = { "clike", "java", "c" },
        grammarLocatorClassName = ".MyGrammarLocator"
)
public class MyClass {}
