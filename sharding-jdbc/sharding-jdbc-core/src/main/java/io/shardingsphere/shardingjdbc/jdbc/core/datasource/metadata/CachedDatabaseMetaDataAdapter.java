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

package io.shardingsphere.shardingjdbc.jdbc.core.datasource.metadata;

/**
 * Cached database meta data adapter.
 *
 * @author zhangliang
 */
public abstract class CachedDatabaseMetaDataAdapter extends UnsupportedOperationCachedMetaData {
    
    @Override
    public final boolean ownInsertsAreVisible(final int type) {
        return true;
    }
    
    @Override
    public final boolean ownUpdatesAreVisible(final int type) {
        return true;
    }
    
    @Override
    public final boolean ownDeletesAreVisible(final int type) {
        return true;
    }
    
    @Override
    public final boolean othersInsertsAreVisible(final int type) {
        return true;
    }
    
    @Override
    public final boolean othersUpdatesAreVisible(final int type) {
        return true;
    }
    
    @Override
    public final boolean othersDeletesAreVisible(final int type) {
        return true;
    }
    
    @Override
    public final boolean insertsAreDetected(final int type) {
        return true;
    }
    
    @Override
    public final boolean updatesAreDetected(final int type) {
        return true;
    }
    
    @Override
    public final boolean deletesAreDetected(final int type) {
        return true;
    }
    
    @Override
    public final boolean supportsResultSetType(final int type) {
        return true;
    }
    
    @Override
    public final boolean supportsResultSetConcurrency(final int type, final int concurrency) {
        return true;
    }
    
    @Override
    public final boolean supportsResultSetHoldability(final int holdability) {
        return true;
    }
    
    @Override
    public final boolean supportsTransactionIsolationLevel(final int level) {
        return true;
    }
}
