package org.vufind.solr.handler.client.solrj;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.common.params.SolrParams;

public class BrowseRequest extends SolrRequest<BrowseResponse>
{

    private SolrParams query = null;

    /**
     * Assume browse handler is configured at "/browse".
     */
    public static String path = "/browse";

    public BrowseRequest()
    {
        super(METHOD.GET, path);
    }

    public BrowseRequest(SolrParams q)
    {
        super(METHOD.GET, path);
        query = q;
    }


    public BrowseRequest(METHOD m, String path)
    {
        super(m, path);
        // TODO Auto-generated constructor stub
    }

    @Override
    public SolrParams getParams()
    {
        return query;
    }

    @Override
    protected BrowseResponse createResponse(SolrClient client)
    {
        return new BrowseResponse(client);
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
