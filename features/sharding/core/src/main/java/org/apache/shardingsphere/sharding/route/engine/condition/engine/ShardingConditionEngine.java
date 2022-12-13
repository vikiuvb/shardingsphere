/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sharding.route.engine.condition.engine;

import org.apache.shardingsphere.sharding.route.engine.condition.ShardingCondition;
import org.apache.shardingsphere.infra.binder.statement.SQLStatementContext;

import java.util.List;
import org.apache.shardingsphere.infra.metadata.database.ShardingSphereDatabase;
import org.apache.shardingsphere.infra.util.spi.type.required.RequiredSPI;
import org.apache.shardingsphere.sharding.rule.ShardingRule;

/**
 * Sharding condition engine.
 */
public interface ShardingConditionEngine<T extends SQLStatementContext<?>> extends RequiredSPI {
    
    /**
     * Initialize the sharding condition engine.
     *
     * @param rule Sharding rule
     * @param database Sharding database
     */
    void init(ShardingRule rule, ShardingSphereDatabase database);
    
    /**
     * Create sharding conditions.
     *
     * @param sqlStatementContext SQL statement context
     * @param params SQL parameters
     * @return sharding conditions
     */
    List<ShardingCondition> createShardingConditions(T sqlStatementContext, List<Object> params);
}
