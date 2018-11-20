package org.vufind.solr.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


//TODO: fix up ids structure

class BrowseItem
{
    public List<String> seeAlso = new LinkedList<String> ();
    public List<String> useInstead = new LinkedList<String> ();
    public String note = "";
    public String sort_key;
    public String heading;
    public List<String> ids = null;
    public Map<String, List<Collection<String>>> fields = new HashMap<> ();
    int count;


    public BrowseItem(String sort_key, String heading)
    {
        this.sort_key = sort_key;
        this.heading = heading;
    }

// ids are gathered into List<Collection<String>>, see bibinfo in
// BibDB.matchingIDs() and populateItem().
    public void setIds(List<Collection<String>> idList)
    {
        ids = new ArrayList<String> ();
        for (Collection<String> idCol : idList) {
            ids.addAll(idCol);
        }
        this.ids = ids;
    }

    public Map<String, Object> asMap()
    {
        Map<String, Object> result = new HashMap<> ();

        result.put("sort_key", sort_key);
        result.put("heading", heading);
        result.put("seeAlso", seeAlso);
        result.put("useInstead", useInstead);
        result.put("note", note);
        result.put("count", new Integer(count));
        result.put("ids", ids);
        result.put("fields", fields);

        return result;
    }
}
