package edu.stanford.math.plex_viewer;

import edu.stanford.math.plex4.homology.chain_basis.Simplex;
import edu.stanford.math.plex4.streams.impl.GeometricSimplexStream;
import edu.stanford.math.plex4.streams.interfaces.AbstractFilteredStream;
import edu.stanford.math.primitivelib.autogen.formal_sum.DoubleSparseFormalSum;
import edu.stanford.math.primitivelib.autogen.pair.ObjectObjectPair;
import edu.stanford.math.primitivelib.metric.interfaces.AbstractObjectMetricSpace;

/**
 * This class contains static functions for drawing various objects. It serves as an API
 * for the plex-viewer project.
 * 
 * @author Andrew Tausz
 *
 */
public class PlexViewer {
	
	public static void main(String[] args) {}
	
	public static void drawSimplexStream(AbstractFilteredStream<Simplex> stream, AbstractObjectMetricSpace<double[]> metricSpace) {
		OpenGLManager openGLManager = new OpenGLManager(new SimplexStreamViewer(stream, metricSpace));
		openGLManager.initialize();
	}
	
	public static void drawSimplexStream(AbstractFilteredStream<Simplex> stream, double[][] points) {
		OpenGLManager openGLManager = new OpenGLManager(new SimplexStreamViewer(stream, points));
		openGLManager.initialize();
	}
	
	public static void drawSimplexStream(GeometricSimplexStream geometricSimplexStream) {
		OpenGLManager openGLManager = new OpenGLManager(new SimplexStreamViewer(geometricSimplexStream));
		openGLManager.initialize();
	}
	
	public static void drawMapping(AbstractFilteredStream<Simplex> domainStream, double[][] domainPoints, 
			AbstractFilteredStream<Simplex> codomainStream, double[][] codomainPoints,
			DoubleSparseFormalSum<ObjectObjectPair<Simplex, Simplex>> mapping) {
		MappingViewer mappingViewer = new MappingViewer(domainStream, domainPoints, codomainStream, codomainPoints, mapping);
		OpenGLManager openGLManager = new OpenGLManager(mappingViewer);
		openGLManager.initialize();
	}
	
	public static void drawMapping(AbstractFilteredStream<Simplex> domainStream, double[][] domainPoints, 
			AbstractFilteredStream<Simplex> codomainStream, double[][] codomainPoints,
			double[][] matrix) {
		MappingViewer mappingViewer = new MappingViewer(domainStream, domainPoints, codomainStream, codomainPoints, matrix);
		OpenGLManager openGLManager = new OpenGLManager(mappingViewer);
		openGLManager.initialize();
	}
}
