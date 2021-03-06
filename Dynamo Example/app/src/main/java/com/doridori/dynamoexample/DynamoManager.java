package com.doridori.dynamoexample;

import couk.doridori.dynamo.DynamoHolder;

/**
 * Singleton. Handles Dynamo instances.
 *
 * If using Dagger you may want to inject this class as a @Singleton instead
 */
public class DynamoManager
{
    //======================================================================================
    // Singleton
    //======================================================================================

    private static DynamoManager sInstance = new DynamoManager();

    public static synchronized DynamoManager getInstance()
    {
        return sInstance;
    }

    //======================================================================================
    // Computation Dynamo mgmt
    //======================================================================================

    /**
     * Dynamo manager declaration
     */
    public DynamoHolder<ComputationDynamo> mComputationDynamoHolder = new DynamoHolder<ComputationDynamo>(1);

    /**
     * Getter from the ComputationDynamo. We could've passed in extra args to this method if the Dynamo needed some initialisation data.
     *
     * @param See {@link couk.doridori.dynamo.DynamoHolder#getDynamo(String, couk.doridori.dynamo.DynamoHolder.DynamoFactory)} method
     * @return
     */
    public ComputationDynamo getComputationDynamo(String meta)
    {
        return mComputationDynamoHolder.getDynamo(meta, new DynamoHolder.DynamoFactory<ComputationDynamo>()
        {
            @Override public ComputationDynamo buildDynamo()
            {
                return new ComputationDynamo();
            }
        });
    }

}
