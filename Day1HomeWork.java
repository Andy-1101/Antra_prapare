import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/*
 * The interface
 */
interface SongCache{
    /**
     * Record number of plays for a song
     * @param songId
     * @param numPlays
     */
    void recordSongPlays(String songId, int numPlays);

    /**
     * Fetch the number if palys for a song
     * @return the number of plays, or -1 if the song Id is unknown
     */
    int getPlaysForSong(String songId);

    /**
     * Return the top N songs played, in descending order of number of plays.
     */
    List<String> getTopNSongsPlayed(int n);

}


/*
 * Use class to implement the interface, the interface can't be instanciated,
 * but the class implements the interface can be instanciated
 */
class SongCacheImpl implements SongCache{
    private final HashMap<String, Integer> songRecords = new HashMap<>(); // the instance variable to records songId and times been played

    SongCacheImpl(){

    }

    @Override
    public synchronized void recordSongPlays(String songId, int numPlays) { // everytime call this function, the hashmap will add the times played for a specid song and add it to hashmap
        songRecords.put(songId, songRecords.getOrDefault(songId, 0) + numPlays); // if the songId is added to the HashMap the first time, then use 0 as default value and add the times played

    }

    @Override
    public int getPlaysForSong(String songId){
        if (songRecords.containsKey(songId)){ // if the songId already inside the hashmap, return the value as the number of times played
            return songRecords.get(songId);
        }
        return -1; // if the songId is unknown justg return -1

    }

    @Override
    public List<String> getTopNSongsPlayed(int n){// use max-heap to return songs in deceding order of number of playes
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder())); // PriorityQueue compare by value
        for(Map.Entry<String, Integer> cur : songRecords.entrySet()){ // put all elements from Hashmap to PriorityQueue
            queue.offer(cur);
        }

        List<String> res = new ArrayList<>(); // intiate the result list

        for(int i=0; i<n;i++){
            Map.Entry<String, Integer> tar = queue.poll(); // poll number of most played songs
            res.add(tar.getKey());

            if(queue.isEmpty()) break; // if the pq is empty, means the input n > number of elements inside the pq, then just terminate the process
        }

        return res;

    }

}



public class Day1HomeWork {

    @Test
    public void cacheIsWorking(){
        SongCache cache = new SongCacheImpl();

        cache.recordSongPlays("ID-1", 3);
        cache.recordSongPlays("ID-1", 1);
        cache.recordSongPlays("ID-2", 2);
        cache.recordSongPlays("ID-3", 5);

        assertThat(cache.getPlaysForSong("ID-1"), is(4));
        assertThat(cache.getPlaysForSong("ID-9"), is(-1));
        assertThat(cache.getTopNSongsPlayed(2).contains("ID-3") &&
                cache.getTopNSongsPlayed(2).contains("ID-1") , is(true));
        assertThat(cache.getTopNSongsPlayed(0).isEmpty(),is(true));

    }



    public static void main(String[] args){
        /*
         * self-made Test
         */
        //System.out.println(cache.getPlaysForSong("ID-1") == (4)); // true
        //System.out.println(cache.getPlaysForSong("ID-9") == (-1)); // true
        //System.out.println(cache.getTopNSongsPlayed(2).containsAll(Arrays.asList("ID-1","ID-3"))); // true
        //System.out.println(cache.getTopNSongsPlayed(0).isEmpty()); // true

        Day1HomeWork dh = new Day1HomeWork();
        dh.cacheIsWorking();

    }

}
