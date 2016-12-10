// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.vjames19.demo.grpc.proto;

/**
 * Protobuf type {@code com.vjames19.demo.grpc.UserProjectsResponse}
 */
public  final class UserProjectsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.vjames19.demo.grpc.UserProjectsResponse)
    UserProjectsResponseOrBuilder {
  // Use UserProjectsResponse.newBuilder() to construct.
  private UserProjectsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserProjectsResponse() {
    project_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private UserProjectsResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              project_ = new java.util.ArrayList<com.vjames19.demo.grpc.proto.Project>();
              mutable_bitField0_ |= 0x00000001;
            }
            project_.add(
                input.readMessage(com.vjames19.demo.grpc.proto.Project.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        project_ = java.util.Collections.unmodifiableList(project_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.vjames19.demo.grpc.proto.UserServiceProtos.internal_static_com_vjames19_demo_grpc_UserProjectsResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.vjames19.demo.grpc.proto.UserServiceProtos.internal_static_com_vjames19_demo_grpc_UserProjectsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.vjames19.demo.grpc.proto.UserProjectsResponse.class, com.vjames19.demo.grpc.proto.UserProjectsResponse.Builder.class);
  }

  public static final int PROJECT_FIELD_NUMBER = 1;
  private java.util.List<com.vjames19.demo.grpc.proto.Project> project_;
  /**
   * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
   */
  public java.util.List<com.vjames19.demo.grpc.proto.Project> getProjectList() {
    return project_;
  }
  /**
   * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
   */
  public java.util.List<? extends com.vjames19.demo.grpc.proto.ProjectOrBuilder> 
      getProjectOrBuilderList() {
    return project_;
  }
  /**
   * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
   */
  public int getProjectCount() {
    return project_.size();
  }
  /**
   * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
   */
  public com.vjames19.demo.grpc.proto.Project getProject(int index) {
    return project_.get(index);
  }
  /**
   * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
   */
  public com.vjames19.demo.grpc.proto.ProjectOrBuilder getProjectOrBuilder(
      int index) {
    return project_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < project_.size(); i++) {
      output.writeMessage(1, project_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < project_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, project_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.vjames19.demo.grpc.proto.UserProjectsResponse)) {
      return super.equals(obj);
    }
    com.vjames19.demo.grpc.proto.UserProjectsResponse other = (com.vjames19.demo.grpc.proto.UserProjectsResponse) obj;

    boolean result = true;
    result = result && getProjectList()
        .equals(other.getProjectList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (getProjectCount() > 0) {
      hash = (37 * hash) + PROJECT_FIELD_NUMBER;
      hash = (53 * hash) + getProjectList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.vjames19.demo.grpc.proto.UserProjectsResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.vjames19.demo.grpc.proto.UserProjectsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.vjames19.demo.grpc.UserProjectsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.vjames19.demo.grpc.UserProjectsResponse)
      com.vjames19.demo.grpc.proto.UserProjectsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.vjames19.demo.grpc.proto.UserServiceProtos.internal_static_com_vjames19_demo_grpc_UserProjectsResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.vjames19.demo.grpc.proto.UserServiceProtos.internal_static_com_vjames19_demo_grpc_UserProjectsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.vjames19.demo.grpc.proto.UserProjectsResponse.class, com.vjames19.demo.grpc.proto.UserProjectsResponse.Builder.class);
    }

    // Construct using com.vjames19.demo.grpc.proto.UserProjectsResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getProjectFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (projectBuilder_ == null) {
        project_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        projectBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.vjames19.demo.grpc.proto.UserServiceProtos.internal_static_com_vjames19_demo_grpc_UserProjectsResponse_descriptor;
    }

    public com.vjames19.demo.grpc.proto.UserProjectsResponse getDefaultInstanceForType() {
      return com.vjames19.demo.grpc.proto.UserProjectsResponse.getDefaultInstance();
    }

    public com.vjames19.demo.grpc.proto.UserProjectsResponse build() {
      com.vjames19.demo.grpc.proto.UserProjectsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.vjames19.demo.grpc.proto.UserProjectsResponse buildPartial() {
      com.vjames19.demo.grpc.proto.UserProjectsResponse result = new com.vjames19.demo.grpc.proto.UserProjectsResponse(this);
      int from_bitField0_ = bitField0_;
      if (projectBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          project_ = java.util.Collections.unmodifiableList(project_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.project_ = project_;
      } else {
        result.project_ = projectBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.vjames19.demo.grpc.proto.UserProjectsResponse) {
        return mergeFrom((com.vjames19.demo.grpc.proto.UserProjectsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.vjames19.demo.grpc.proto.UserProjectsResponse other) {
      if (other == com.vjames19.demo.grpc.proto.UserProjectsResponse.getDefaultInstance()) return this;
      if (projectBuilder_ == null) {
        if (!other.project_.isEmpty()) {
          if (project_.isEmpty()) {
            project_ = other.project_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureProjectIsMutable();
            project_.addAll(other.project_);
          }
          onChanged();
        }
      } else {
        if (!other.project_.isEmpty()) {
          if (projectBuilder_.isEmpty()) {
            projectBuilder_.dispose();
            projectBuilder_ = null;
            project_ = other.project_;
            bitField0_ = (bitField0_ & ~0x00000001);
            projectBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getProjectFieldBuilder() : null;
          } else {
            projectBuilder_.addAllMessages(other.project_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.vjames19.demo.grpc.proto.UserProjectsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.vjames19.demo.grpc.proto.UserProjectsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.vjames19.demo.grpc.proto.Project> project_ =
      java.util.Collections.emptyList();
    private void ensureProjectIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        project_ = new java.util.ArrayList<com.vjames19.demo.grpc.proto.Project>(project_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.vjames19.demo.grpc.proto.Project, com.vjames19.demo.grpc.proto.Project.Builder, com.vjames19.demo.grpc.proto.ProjectOrBuilder> projectBuilder_;

    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public java.util.List<com.vjames19.demo.grpc.proto.Project> getProjectList() {
      if (projectBuilder_ == null) {
        return java.util.Collections.unmodifiableList(project_);
      } else {
        return projectBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public int getProjectCount() {
      if (projectBuilder_ == null) {
        return project_.size();
      } else {
        return projectBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public com.vjames19.demo.grpc.proto.Project getProject(int index) {
      if (projectBuilder_ == null) {
        return project_.get(index);
      } else {
        return projectBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder setProject(
        int index, com.vjames19.demo.grpc.proto.Project value) {
      if (projectBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProjectIsMutable();
        project_.set(index, value);
        onChanged();
      } else {
        projectBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder setProject(
        int index, com.vjames19.demo.grpc.proto.Project.Builder builderForValue) {
      if (projectBuilder_ == null) {
        ensureProjectIsMutable();
        project_.set(index, builderForValue.build());
        onChanged();
      } else {
        projectBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder addProject(com.vjames19.demo.grpc.proto.Project value) {
      if (projectBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProjectIsMutable();
        project_.add(value);
        onChanged();
      } else {
        projectBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder addProject(
        int index, com.vjames19.demo.grpc.proto.Project value) {
      if (projectBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProjectIsMutable();
        project_.add(index, value);
        onChanged();
      } else {
        projectBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder addProject(
        com.vjames19.demo.grpc.proto.Project.Builder builderForValue) {
      if (projectBuilder_ == null) {
        ensureProjectIsMutable();
        project_.add(builderForValue.build());
        onChanged();
      } else {
        projectBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder addProject(
        int index, com.vjames19.demo.grpc.proto.Project.Builder builderForValue) {
      if (projectBuilder_ == null) {
        ensureProjectIsMutable();
        project_.add(index, builderForValue.build());
        onChanged();
      } else {
        projectBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder addAllProject(
        java.lang.Iterable<? extends com.vjames19.demo.grpc.proto.Project> values) {
      if (projectBuilder_ == null) {
        ensureProjectIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, project_);
        onChanged();
      } else {
        projectBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder clearProject() {
      if (projectBuilder_ == null) {
        project_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        projectBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public Builder removeProject(int index) {
      if (projectBuilder_ == null) {
        ensureProjectIsMutable();
        project_.remove(index);
        onChanged();
      } else {
        projectBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public com.vjames19.demo.grpc.proto.Project.Builder getProjectBuilder(
        int index) {
      return getProjectFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public com.vjames19.demo.grpc.proto.ProjectOrBuilder getProjectOrBuilder(
        int index) {
      if (projectBuilder_ == null) {
        return project_.get(index);  } else {
        return projectBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public java.util.List<? extends com.vjames19.demo.grpc.proto.ProjectOrBuilder> 
         getProjectOrBuilderList() {
      if (projectBuilder_ != null) {
        return projectBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(project_);
      }
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public com.vjames19.demo.grpc.proto.Project.Builder addProjectBuilder() {
      return getProjectFieldBuilder().addBuilder(
          com.vjames19.demo.grpc.proto.Project.getDefaultInstance());
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public com.vjames19.demo.grpc.proto.Project.Builder addProjectBuilder(
        int index) {
      return getProjectFieldBuilder().addBuilder(
          index, com.vjames19.demo.grpc.proto.Project.getDefaultInstance());
    }
    /**
     * <code>repeated .com.vjames19.demo.grpc.Project project = 1;</code>
     */
    public java.util.List<com.vjames19.demo.grpc.proto.Project.Builder> 
         getProjectBuilderList() {
      return getProjectFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.vjames19.demo.grpc.proto.Project, com.vjames19.demo.grpc.proto.Project.Builder, com.vjames19.demo.grpc.proto.ProjectOrBuilder> 
        getProjectFieldBuilder() {
      if (projectBuilder_ == null) {
        projectBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.vjames19.demo.grpc.proto.Project, com.vjames19.demo.grpc.proto.Project.Builder, com.vjames19.demo.grpc.proto.ProjectOrBuilder>(
                project_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        project_ = null;
      }
      return projectBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.vjames19.demo.grpc.UserProjectsResponse)
  }

  // @@protoc_insertion_point(class_scope:com.vjames19.demo.grpc.UserProjectsResponse)
  private static final com.vjames19.demo.grpc.proto.UserProjectsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.vjames19.demo.grpc.proto.UserProjectsResponse();
  }

  public static com.vjames19.demo.grpc.proto.UserProjectsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserProjectsResponse>
      PARSER = new com.google.protobuf.AbstractParser<UserProjectsResponse>() {
    public UserProjectsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UserProjectsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserProjectsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserProjectsResponse> getParserForType() {
    return PARSER;
  }

  public com.vjames19.demo.grpc.proto.UserProjectsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
