package com.vjames19.demo.grpc.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.2)",
    comments = "Source: user.proto")
public class UserProjectServiceGrpc {

  private UserProjectServiceGrpc() {}

  public static final String SERVICE_NAME = "com.vjames19.demo.grpc.UserProjectService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.vjames19.demo.grpc.proto.UserProjectsRequest,
      com.vjames19.demo.grpc.proto.UserProjectsResponse> METHOD_GET_PROJECTS_FOR_USER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.vjames19.demo.grpc.UserProjectService", "GetProjectsForUser"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.vjames19.demo.grpc.proto.UserProjectsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.vjames19.demo.grpc.proto.UserProjectsResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserProjectServiceStub newStub(io.grpc.Channel channel) {
    return new UserProjectServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserProjectServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserProjectServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static UserProjectServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserProjectServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserProjectServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getProjectsForUser(com.vjames19.demo.grpc.proto.UserProjectsRequest request,
        io.grpc.stub.StreamObserver<com.vjames19.demo.grpc.proto.UserProjectsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PROJECTS_FOR_USER, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_PROJECTS_FOR_USER,
            asyncUnaryCall(
              new MethodHandlers<
                com.vjames19.demo.grpc.proto.UserProjectsRequest,
                com.vjames19.demo.grpc.proto.UserProjectsResponse>(
                  this, METHODID_GET_PROJECTS_FOR_USER)))
          .build();
    }
  }

  /**
   */
  public static final class UserProjectServiceStub extends io.grpc.stub.AbstractStub<UserProjectServiceStub> {
    private UserProjectServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProjectServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProjectServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProjectServiceStub(channel, callOptions);
    }

    /**
     */
    public void getProjectsForUser(com.vjames19.demo.grpc.proto.UserProjectsRequest request,
        io.grpc.stub.StreamObserver<com.vjames19.demo.grpc.proto.UserProjectsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PROJECTS_FOR_USER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserProjectServiceBlockingStub extends io.grpc.stub.AbstractStub<UserProjectServiceBlockingStub> {
    private UserProjectServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProjectServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProjectServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProjectServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.vjames19.demo.grpc.proto.UserProjectsResponse getProjectsForUser(com.vjames19.demo.grpc.proto.UserProjectsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PROJECTS_FOR_USER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserProjectServiceFutureStub extends io.grpc.stub.AbstractStub<UserProjectServiceFutureStub> {
    private UserProjectServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProjectServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProjectServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProjectServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.vjames19.demo.grpc.proto.UserProjectsResponse> getProjectsForUser(
        com.vjames19.demo.grpc.proto.UserProjectsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PROJECTS_FOR_USER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROJECTS_FOR_USER = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserProjectServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(UserProjectServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PROJECTS_FOR_USER:
          serviceImpl.getProjectsForUser((com.vjames19.demo.grpc.proto.UserProjectsRequest) request,
              (io.grpc.stub.StreamObserver<com.vjames19.demo.grpc.proto.UserProjectsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_GET_PROJECTS_FOR_USER);
  }

}
