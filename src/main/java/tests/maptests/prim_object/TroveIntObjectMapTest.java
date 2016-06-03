package tests.maptests.prim_object;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

/**
 * Trove TIntObjectHashMap
 */
public class TroveIntObjectMapTest extends AbstractPrimObjectMapTest {
    private TIntObjectMap<Integer> m_map;
    @Override
    public void setup(int[] keys, float fillFactor) {
        super.setup(keys, fillFactor);
        m_map = new TIntObjectHashMap<>( keys.length, fillFactor );
        for ( final int key : keys ) m_map.put( key, key );
    }

    @Override
    public int runRandomTest() {
        int res = 0;
        for ( int i = 0; i < m_keys.length; ++i )
            res = res ^ m_map.get( m_keys[ i ] );
        return res;
    }
}
