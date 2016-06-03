package tests.maptests.object;

import net.openhft.koloboke.collect.hash.HashConfig;
import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

import java.util.Map;

/**
 * Koloboke mutable object map test
 */
public class HftcMutableObjTest extends AbstractObjObjMapTest {
    private Map<Integer, Integer> m_map;

    @Override
    public void setup(final int[] keys, final float fillFactor) {
        super.setup( keys, fillFactor );
        m_map = HashObjObjMaps.getDefaultFactory().withHashConfig(HashConfig.fromLoads(0.5, 0.6, 0.8)).newMutableMap(keys.length);
        for (Integer key : m_keys)
            m_map.put(key, key);
    }

    @Override
    public int runRandomTest() {
        int res = 0;
        for (int i = 0; i < m_keys.length; ++i) {
            res = res ^ m_map.get(m_keys[i]);
        }
        return res;
    }
}
