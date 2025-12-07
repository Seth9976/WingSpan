package androidx.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class WorkQuery {
    public static final class Builder {
        List mIds;
        List mStates;
        List mTags;
        List mUniqueWorkNames;

        private Builder() {
            this.mIds = new ArrayList();
            this.mUniqueWorkNames = new ArrayList();
            this.mTags = new ArrayList();
            this.mStates = new ArrayList();
        }

        public Builder addIds(List ids) {
            this.mIds.addAll(ids);
            return this;
        }

        public Builder addStates(List states) {
            this.mStates.addAll(states);
            return this;
        }

        public Builder addTags(List tags) {
            this.mTags.addAll(tags);
            return this;
        }

        public Builder addUniqueWorkNames(List uniqueWorkNames) {
            this.mUniqueWorkNames.addAll(uniqueWorkNames);
            return this;
        }

        public WorkQuery build() {
            if(this.mIds.isEmpty() && this.mUniqueWorkNames.isEmpty() && this.mTags.isEmpty() && this.mStates.isEmpty()) {
                throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
            }
            return new WorkQuery(this);
        }

        public static Builder fromIds(List ids) {
            Builder workQuery$Builder0 = new Builder();
            workQuery$Builder0.addIds(ids);
            return workQuery$Builder0;
        }

        public static Builder fromStates(List states) {
            Builder workQuery$Builder0 = new Builder();
            workQuery$Builder0.addStates(states);
            return workQuery$Builder0;
        }

        public static Builder fromTags(List tags) {
            Builder workQuery$Builder0 = new Builder();
            workQuery$Builder0.addTags(tags);
            return workQuery$Builder0;
        }

        public static Builder fromUniqueWorkNames(List uniqueWorkNames) {
            Builder workQuery$Builder0 = new Builder();
            workQuery$Builder0.addUniqueWorkNames(uniqueWorkNames);
            return workQuery$Builder0;
        }
    }

    private final List mIds;
    private final List mStates;
    private final List mTags;
    private final List mUniqueWorkNames;

    WorkQuery(Builder builder) {
        this.mIds = builder.mIds;
        this.mUniqueWorkNames = builder.mUniqueWorkNames;
        this.mTags = builder.mTags;
        this.mStates = builder.mStates;
    }

    public static WorkQuery fromIds(List ids) {
        return Builder.fromIds(ids).build();
    }

    public static WorkQuery fromIds(UUID[] ids) {
        return WorkQuery.fromIds(Arrays.asList(ids));
    }

    public static WorkQuery fromStates(List states) {
        return Builder.fromStates(states).build();
    }

    public static WorkQuery fromStates(State[] states) {
        return Builder.fromStates(Arrays.asList(states)).build();
    }

    public static WorkQuery fromTags(List tags) {
        return Builder.fromTags(tags).build();
    }

    public static WorkQuery fromTags(String[] tags) {
        return WorkQuery.fromTags(Arrays.asList(tags));
    }

    public static WorkQuery fromUniqueWorkNames(List uniqueWorkNames) {
        return Builder.fromUniqueWorkNames(uniqueWorkNames).build();
    }

    public static WorkQuery fromUniqueWorkNames(String[] uniqueWorkNames) {
        return Builder.fromUniqueWorkNames(Arrays.asList(uniqueWorkNames)).build();
    }

    public List getIds() {
        return this.mIds;
    }

    public List getStates() {
        return this.mStates;
    }

    public List getTags() {
        return this.mTags;
    }

    public List getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }
}

