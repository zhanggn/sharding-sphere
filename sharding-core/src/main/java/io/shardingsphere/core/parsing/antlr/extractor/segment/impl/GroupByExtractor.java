/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.antlr.extractor.segment.impl;

import com.google.common.base.Optional;
import io.shardingsphere.core.parsing.antlr.extractor.segment.OptionalSQLSegmentExtractor;
import io.shardingsphere.core.parsing.antlr.extractor.segment.constant.RuleName;
import io.shardingsphere.core.parsing.antlr.extractor.util.ExtractorUtils;
import io.shardingsphere.core.parsing.antlr.sql.segment.order.GroupBySegment;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Group by extractor.
 *
 * @author duhongjun
 */
public final class GroupByExtractor implements OptionalSQLSegmentExtractor {
    
    @Override
    public Optional<GroupBySegment> extract(final ParserRuleContext ancestorNode) {
        Optional<ParserRuleContext> selectClauseNode = ExtractorUtils.findFirstChildNode(ancestorNode, RuleName.SELECT_CLAUSE);
        if (!selectClauseNode.isPresent()) {
            return Optional.absent();
        }
        Optional<ParserRuleContext> orderByParentNode = ExtractorUtils.findFirstChildNodeNoneRecursive(selectClauseNode.get().getParent(), RuleName.GROUP_BY_CLAUSE);
        if (!orderByParentNode.isPresent()) {
            return Optional.absent();
        }
        GroupBySegment result = new GroupBySegment(orderByParentNode.get().getStop().getStopIndex() + 1);
        result.getGroupByItems().addAll(new OrderByExtractor().extractOrderBy(orderByParentNode.get()));
        return Optional.of(result);
    }
}
