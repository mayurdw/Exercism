import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Grep Tool Emulator
 */
public class GrepTool {

    private enum GREP_OPTIONS {
        NONE( "" ),
        PRINT_LINE_NUMBER( "-n" ),
        NAMES_OF_FILES( "-l" ),
        CASE_INSENSITIVE( "-i" ),
        INVERT_MATCHING( "-v" ),
        ONLY_MATCH_ENTIRE_LINES( "-x" );

        private final String OPTIONS;

        GREP_OPTIONS( String options ) {
            this.OPTIONS = options;
        }

        static List<GREP_OPTIONS> extractOptions( List<String> options ) {
            List<GREP_OPTIONS> grepOptions = new ArrayList<>();

            if ( options != null && !options.isEmpty() ) {
                for ( GREP_OPTIONS a : GREP_OPTIONS.values() ) {
                    if ( options.contains( a.OPTIONS ) ) {
                        grepOptions.add( a );
                    }
                }
            }

            if ( grepOptions.isEmpty() ) {
                grepOptions.add( NONE );
            }

            return grepOptions;
        }
    }

    // TODO: Need to combine with GREP_OPTIONS
    // TODO: Need invert flag
    private static class Grep_Flags {
        boolean caseInsensitive;
        boolean fileNamesOnly;
        boolean includeLineNumbers;

        Grep_Flags( List<GREP_OPTIONS> grepOptions ){
            this.caseInsensitive = grepOptions.contains( GREP_OPTIONS.CASE_INSENSITIVE );
            this.fileNamesOnly = grepOptions.contains( GREP_OPTIONS.NAMES_OF_FILES );
            this.includeLineNumbers = grepOptions.contains( GREP_OPTIONS.PRINT_LINE_NUMBER );
        }
    }

    /**
     * File Opening helper
     *
     * @param fileName that needs to be opened
     * @throws java.io.IOException if file doesn't exist
     */
    private String[] fileReadHelper( String fileName ) throws IOException {
        Path file = Paths.get( fileName );
        String fileContents = Files.readString( file, StandardCharsets.UTF_8 );

        return fileContents.split( "\n" );
    }

    private String matchPattern( String pattern, String line, boolean caseInsensitive ){
        if( line.contains( pattern ) ){
            return line.substring( 0, line.length() - 1 );
        } else if( caseInsensitive && line.toLowerCase( Locale.ROOT ).contains( pattern ) ){
            return line.substring( 0, line.length() - 1 );
        }

        return "";
    }

    /**
     * Returns the matched patterns
     *
     * @param pattern   to be matched
     * @param options   grep options
     * @param fileNames to be scanned
     */
    public String grep( String pattern, List<String> options, List<String> fileNames ) {
        Grep_Flags grepFlags = new Grep_Flags( GREP_OPTIONS.extractOptions( options ) );
        final boolean fileNamePrefix = fileNames.size() > 1;
        StringBuilder stringBuilder = new StringBuilder();

        if( grepFlags.caseInsensitive ){
            pattern = pattern.toLowerCase( Locale.ROOT );
        }

        for( String fileName : fileNames ){
            try {
                String[] fileLines = this.fileReadHelper( fileName );
                int lineNumber = 1;

                for( String line : fileLines ){

                    String match = this.matchPattern( pattern, line, grepFlags.caseInsensitive );
                    if( !match.isEmpty() ){
                        if( grepFlags.fileNamesOnly ){
                            stringBuilder.append( fileName );
                            break;
                        } else {
                            if( grepFlags.includeLineNumbers ){
                                stringBuilder.append( lineNumber ).append( ":" );
                            }
                            stringBuilder.append( match );
                        }
                    }
                    lineNumber++;
                }
            } catch ( Exception e ){
                e.printStackTrace();
                return "";
            }
        }

        return stringBuilder.toString();
    }


}