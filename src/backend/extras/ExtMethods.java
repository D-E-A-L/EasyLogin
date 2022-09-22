package backend.extras;

import java.util.*;

public class ExtMethods<T> {

    public ExtMethods(){}

    //region extras
    /*English: Method that converts an object to list with type String*/
    public List<?> objKeyConvertToList(HashMap<?,?> mhm){
        Set<?> nSet = mhm.keySet();
        return new ArrayList<>(nSet);
    }

    public boolean existElmt(HashMap<?,?> myHash, T src){
        return (objKeyConvertToList(myHash)).contains(src);
    }

    public boolean elemExist(HashMap<?,?> myHash, T src){
        return existElmt(myHash,src);
    }

    public boolean existObject(Object obj, T src){
        HashMap<?,?> myHash = (HashMap<?, ?>) obj;
        return (objKeyConvertToList(myHash)).contains(src);
    }
    //endregion
}
