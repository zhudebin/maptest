package tests.maptests.object_prim;

import tests.maptests.IMapTest;

/**
 * Base class for all object to primitive tests
 */
public abstract class AbstractObjPrimMapTest implements IMapTest {
    protected Integer[] m_keys;

    @Override
    public void setup(final int[] keys, final float fillFactor) {
        m_keys = new Integer[ keys.length ];
        for ( int i = 0; i < keys.length; ++i )
            m_keys[ i ] = keys[ i ];
    }
}
