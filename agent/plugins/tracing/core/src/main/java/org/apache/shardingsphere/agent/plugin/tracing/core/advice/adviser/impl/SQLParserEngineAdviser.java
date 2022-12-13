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

package org.apache.shardingsphere.agent.plugin.tracing.core.advice.adviser.impl;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.matcher.ElementMatchers;
import org.apache.shardingsphere.agent.core.definition.PointcutDefinitionServiceEngine;
import org.apache.shardingsphere.agent.core.plugin.advice.InstanceMethodAroundAdvice;
import org.apache.shardingsphere.agent.plugin.tracing.core.advice.adviser.TracingAdviser;
import org.apache.shardingsphere.agent.pointcut.ClassPointcuts;
import org.apache.shardingsphere.agent.pointcut.InstanceMethodPointcut;

/**
 * SQL parser engine adviser.
 */
@RequiredArgsConstructor
public final class SQLParserEngineAdviser implements TracingAdviser {
    
    private static final String TARGET_CLASS = "org.apache.shardingsphere.infra.parser.ShardingSphereSQLParserEngine";
    
    private static final String TARGET_METHOD = "parse";
    
    private final PointcutDefinitionServiceEngine engine;
    
    @Override
    public ClassPointcuts advice(final Class<? extends InstanceMethodAroundAdvice> sqlParserEngineAdvice) {
        ClassPointcuts result = engine.getAllPointcuts(TARGET_CLASS);
        result.getInstanceMethodPointcuts().add(new InstanceMethodPointcut(ElementMatchers.named(TARGET_METHOD), sqlParserEngineAdvice.getName()));
        return result;
    }
}
