package com.onesignal.core.internal.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001A\u00020\bH\u0016J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J(\u0010\u0007\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\fH\u0016J(\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\fH\u0016J(\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\fH\u0016J\u0010\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\bH\u0002J\u0013\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u001A\u0010\u0002\u001A\u00020\u0001X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0003¨\u0006\u001B"}, d2 = {"Lcom/onesignal/core/internal/http/impl/TLS12SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)V", "getSslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactory", "createSocket", "Ljava/net/Socket;", "host", "Ljava/net/InetAddress;", "port", "", "address", "localAddress", "localPort", "s", "", "autoClose", "", "localHost", "enableTLS", "socket", "getDefaultCipherSuites", "", "()[Ljava/lang/String;", "getSupportedCipherSuites", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TLS12SocketFactory extends SSLSocketFactory {
    private SSLSocketFactory sslSocketFactory;

    public TLS12SocketFactory(SSLSocketFactory sSLSocketFactory0) {
        Intrinsics.checkNotNullParameter(sSLSocketFactory0, "sslSocketFactory");
        super();
        this.sslSocketFactory = sSLSocketFactory0;
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        Socket socket0 = this.sslSocketFactory.createSocket();
        Intrinsics.checkNotNullExpressionValue(socket0, "sslSocketFactory.createSocket()");
        return this.enableTLS(socket0);
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket(String s, int v) throws IOException {
        Intrinsics.checkNotNullParameter(s, "host");
        Socket socket0 = this.sslSocketFactory.createSocket(s, v);
        Intrinsics.checkNotNullExpressionValue(socket0, "sslSocketFactory.createSocket(host, port)");
        return this.enableTLS(socket0);
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket(String s, int v, InetAddress inetAddress0, int v1) throws IOException {
        Intrinsics.checkNotNullParameter(s, "host");
        Intrinsics.checkNotNullParameter(inetAddress0, "localHost");
        Socket socket0 = this.sslSocketFactory.createSocket(s, v, inetAddress0, v1);
        Intrinsics.checkNotNullExpressionValue(socket0, "sslSocketFactory.createS…rt, localHost, localPort)");
        return this.enableTLS(socket0);
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress0, int v) throws IOException {
        Intrinsics.checkNotNullParameter(inetAddress0, "host");
        Socket socket0 = this.sslSocketFactory.createSocket(inetAddress0, v);
        Intrinsics.checkNotNullExpressionValue(socket0, "sslSocketFactory.createSocket(host, port)");
        return this.enableTLS(socket0);
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress0, int v, InetAddress inetAddress1, int v1) throws IOException {
        Intrinsics.checkNotNullParameter(inetAddress0, "address");
        Intrinsics.checkNotNullParameter(inetAddress1, "localAddress");
        Socket socket0 = this.sslSocketFactory.createSocket(inetAddress0, v, inetAddress1, v1);
        Intrinsics.checkNotNullExpressionValue(socket0, "sslSocketFactory.createS… localAddress, localPort)");
        return this.enableTLS(socket0);
    }

    @Override  // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket0, String s, int v, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(socket0, "s");
        Intrinsics.checkNotNullParameter(s, "host");
        Socket socket1 = this.sslSocketFactory.createSocket(socket0, s, v, z);
        Intrinsics.checkNotNullExpressionValue(socket1, "sslSocketFactory.createS…s, host, port, autoClose)");
        return this.enableTLS(socket1);
    }

    private final Socket enableTLS(Socket socket0) {
        if(socket0 instanceof SSLSocket) {
            ((SSLSocket)socket0).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket0;
    }

    @Override  // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] arr_s = this.sslSocketFactory.getDefaultCipherSuites();
        Intrinsics.checkNotNullExpressionValue(arr_s, "sslSocketFactory.defaultCipherSuites");
        return arr_s;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Override  // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] arr_s = this.sslSocketFactory.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(arr_s, "sslSocketFactory.supportedCipherSuites");
        return arr_s;
    }

    public final void setSslSocketFactory(SSLSocketFactory sSLSocketFactory0) {
        Intrinsics.checkNotNullParameter(sSLSocketFactory0, "<set-?>");
        this.sslSocketFactory = sSLSocketFactory0;
    }
}

