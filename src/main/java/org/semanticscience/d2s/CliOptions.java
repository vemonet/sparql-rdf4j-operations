package org.semanticscience.d2s;

import org.semanticscience.d2s.operations.QueryOperations;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "d2s-sparql-operations")
public class CliOptions {
	@Option(names = { "-h", "--help" }, usageHelp = true, description = "Display a help message")
	boolean help = false;
	
	@Option(names= {"-q", "--query"}, description = "SPARQL query string to execute.")
	String sparqlQuery = null;
	
	@Option(names= {"-i", "--input"}, description = "Path of file(s) to execute. Single file from URL or filepath. Multiple files from directory (query files must have .rq extension). YAML file.")
	String inputFile = null;
	
	@Option(names= {"-o", "--operation"}, description = "SPARQL query operation (update, construct, select, metadata, split, upload). Default is update")
	QueryOperations queryOperation = QueryOperations.update;
	
	
	// SPARQL endpoint params
	@Option(names= {"-e", "--endpoint"}, required = true, 
			description = "URL of the SPARQL Endpoint to query, or RDF4J Server. e.g. https://graphdb.dumontierlab.com/repositories/test or https://graphdb.dumontierlab.com")
	String endpointUrl = null;
	
	@Option(names= {"-r", "--repository"}, description = "Repository ID when using a RDF4J Server URL (instead of direct SPARQL endpoint). E.g. test")
	String repositoryId = null;

	@Option(names= {"-u", "--username"}, description = "Username used for SPARQL endpoint authentication")
	String username = null;

	@Option(names= {"-p", "--password"}, description = "Password used for SPARQL endpoint authentication")
	String password = null;
	
	
	// SPARQL query variables
	@Option(names= {"-g", "--graph"}, description = "Graph URI used in some operations (e.g. to upload to a specific graph)")
	String graph;

	@Option(names= {"--var-input"}, description = "Input graph URI variable to replace in the SPARQL query. E.g.: https://w3id.org/d2s/input")
	String varInput;
	
	@Option(names= {"--var-output"}, description = "Output graph URI to upload RDF to, or to be replaced in the SPARQL query. E.g.: https://w3id.org/d2s/output")
	String varOutput;
	
	@Option(names= {"--var-service"}, description = "A SPARQL service URL variable to replace in the SPARQL query. E.g.: http://localhost:7200/repositories/test")
	String varService;
	
	@Option(names= {"--lib"}, description = "The library to use to upload RDF files, rdf4 or jena. Default: rdf4j")
	String useLib = "rdf4j";
	
	// Split params
	@Option(names= {"--split-delimiter"}, description = "Delimiter for the Split operation. Default: ','")
	char splitDelimiter = ',';
	
	@Option(names= {"--split-quote"}, description = "Delimiter for the Trim operation. Default: '\"'")
	char splitQuote = '"'; // TODO: is null char good here? Should we let free?
	
	@Option(names= {"--split-property"}, description = "Property to split. e.g.: 'http://www.w3.org/2000/01/rdf-schema#label'")
	String splitProperty = null;
	
	@Option(names= {"--split-class"}, description = "Class to split. e.g.: 'http://w3id.org/biolink/vocab/GeneGrouping'")
	String splitClass = null;
	
	@Option(names= {"--split-delete"}, description = "Should we delete the splitted statements? Default: false")
	boolean splitDelete = false;
	
	@Option(names= {"--split-buffer-size"}, description = "Number of statements in the RDF4J model before loading it to the SPARQL endpoint. Default: 1000000")
	int splitBufferSize = 1000000;
	
	// URI expansion params
	@Option(names= {"-uex", "--uri-expansion"}, description = "Expand splitted values with URI, use \"infer\" to do it automatically")
	String uriExpansion = null;
	
}