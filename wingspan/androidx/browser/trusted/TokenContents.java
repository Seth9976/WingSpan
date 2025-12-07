package androidx.browser.trusted;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class TokenContents {
    private final byte[] mContents;
    private List mFingerprints;
    private String mPackageName;

    private TokenContents(byte[] contents) {
        this.mContents = contents;
    }

    private TokenContents(byte[] contents, String packageName, List fingerprints) {
        this.mContents = contents;
        this.mPackageName = packageName;
        this.mFingerprints = new ArrayList(fingerprints.size());
        for(Object object0: fingerprints) {
            this.mFingerprints.add(Arrays.copyOf(((byte[])object0), ((byte[])object0).length));
        }
    }

    // 检测为 Lambda 实现
    private static int compareByteArrays(byte[] a, byte[] b) [...]

    static TokenContents create(String packageName, List fingerprints) throws IOException {
        return new TokenContents(TokenContents.createToken(packageName, fingerprints), packageName, fingerprints);
    }

    private static byte[] createToken(String packageName, List fingerprints) throws IOException {
        Collections.sort(fingerprints, (byte[] a, byte[] b) -> {
            if(a == b) {
                return 0;
            }
            if(a == null) {
                return -1;
            }
            if(b == null) {
                return 1;
            }
            for(int v = 0; v < Math.min(a.length, b.length); ++v) {
                int v1 = a[v];
                int v2 = b[v];
                if(v1 != v2) {
                    return v1 - v2;
                }
            }
            return a.length == b.length ? 0 : a.length - b.length;
        });
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream0 = new DataOutputStream(byteArrayOutputStream0);
        dataOutputStream0.writeUTF(packageName);
        dataOutputStream0.writeInt(fingerprints.size());
        for(Object object0: fingerprints) {
            dataOutputStream0.writeInt(((byte[])object0).length);
            dataOutputStream0.write(((byte[])object0));
        }
        dataOutputStream0.flush();
        return byteArrayOutputStream0.toByteArray();
    }

    static TokenContents deserialize(byte[] serialized) {
        return new TokenContents(serialized);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        return o == null || this.getClass() != o.getClass() ? false : Arrays.equals(this.mContents, ((TokenContents)o).mContents);
    }

    public byte[] getFingerprint(int i) throws IOException {
        this.parseIfNeeded();
        List list0 = this.mFingerprints;
        if(list0 == null) {
            throw new IllegalStateException();
        }
        return Arrays.copyOf(((byte[])list0.get(i)), ((byte[])this.mFingerprints.get(i)).length);
    }

    public int getFingerprintCount() throws IOException {
        this.parseIfNeeded();
        List list0 = this.mFingerprints;
        if(list0 == null) {
            throw new IllegalStateException();
        }
        return list0.size();
    }

    public String getPackageName() throws IOException {
        this.parseIfNeeded();
        String s = this.mPackageName;
        if(s == null) {
            throw new IllegalStateException();
        }
        return s;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.mContents);
    }

    private void parseIfNeeded() throws IOException {
        if(this.mPackageName != null) {
            return;
        }
        DataInputStream dataInputStream0 = new DataInputStream(new ByteArrayInputStream(this.mContents));
        this.mPackageName = dataInputStream0.readUTF();
        int v = dataInputStream0.readInt();
        this.mFingerprints = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = dataInputStream0.readInt();
            byte[] arr_b = new byte[v2];
            if(dataInputStream0.read(arr_b) != v2) {
                throw new IllegalStateException("Could not read fingerprint");
            }
            this.mFingerprints.add(arr_b);
        }
    }

    public byte[] serialize() {
        return Arrays.copyOf(this.mContents, this.mContents.length);
    }
}

