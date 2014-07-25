flying-saucer-playground
========================

[emptyListsItems.html](src/main/resources/lachdrache/emptyListItems.html)
demonstrates how empty list items behave when you set `list-style: none`
and use `li:before`. You can view it your browser of choice or run the
[EmptyListItems.java](src/main/java/lachdrache/EmptyListItems.java) to generate the PDF with
[Flying Saucer](https://code.google.com/p/flying-saucer/).

[documentSectionsWithSeparatePageNumbers.html](src/main/resources/lachdrache/documentSectionsWithSeparatePageNumbers.html)
has document sections with separate page numbers:

- A first page (no headers)
- TOC page (no headers)
- English version (header with page numbering)
- German version (header with page numbering starting from 1 again)

Generate a PDF from it with [DocumentSectionsWithSeparatePageNumbers.java](src/main/java/lachdrache/DocumentSectionsWithSeparatePageNumbers.java).

[PdfGenerator](src/main/java/lachdrache/PdfGenerator.java) demonstrates how to
bridge/redirect Flying Saucer logging to [SLF4J](http://www.slf4j.org).

[latinCounterIssue.html](src/main/resources/lachdrache/latinCounterIssue.html)
demonstrates an issue with latin counters. Generate a PDF by running
[LatinCounterIssue.java](src/main/java/lachdrache/LatinCounterIssue.java).


