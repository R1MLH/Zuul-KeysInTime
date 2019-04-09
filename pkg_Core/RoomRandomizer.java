package pkg_Core;
// import java.util.HashMap;
// import java.util.Set;
// import java.util.Iterator;
// import java.util.Random;
// 
// 
/**
 * une classe static qui permet de renvoyer des rooms aléatoire parmis une collection de room
 * OBSOLETE - NE FONCTIONNE PLUS
 * 
 * @author Erwan Mailharro 
 * @version 22/03/2016
 */
public class RoomRandomizer
{
 
//     /**
//      * renvoie une room aléatoire de la hashmap en parametre
//      */
//     public static Room getRandomRoom(HashMap<String, Room> pMap)
//     {
//         Random rand = new Random();
//         int vRand = rand.nextInt(getKeyNumber(pMap));
//         return getTableau(pMap)[vRand];
//     }
//     
//         /**
//      * renvoie une room aléatoire de la hashmap en parametre
//      */
//     public static Room getRandomRoom()
//     {
//         Random rand = new Random();
//         int vRand = rand.nextInt(8);
//         return GameEngine.getRoomList()[vRand] ;
//     }
// 
//     /**
//      * renvoie le nombre de clé de la hashmap
//      */
//     private static int getKeyNumber(HashMap<String, Room> pMap)
//     {
//         int vNum = 0;
//         Set keys = pMap.keySet();
//         for(Object exit : keys) {
//             vNum++;
//         }
//         return vNum;
//     }
// 
//     /**
//      * renvoie les rooms de la hashmap sous forme de tableau
//      */
//     private static Room[] getTableau(HashMap<String, Room> pMap)
//     {
//         int vNum = 0;
//         Room[] tableau = new Room[getKeyNumber(pMap)];
//         Set<String> keys = pMap.keySet();
//         for(String exit : keys) {
//             tableau[vNum] = pMap.get(exit);
//             vNum++;
//         }
//         return tableau;
//     }
}
