package com.google.android.gms.nearby.messages.audio;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

public final class AudioBytes {
    public static final int MAX_SIZE = 10;
    private final byte[] zzgd;

    public AudioBytes(byte[] arr_b) {
        Preconditions.checkNotNull(arr_b);
        boolean z = true;
        Preconditions.checkArgument(arr_b.length <= 10, "Given byte array longer than 10 bytes, given by AudioBytes.MAX_SIZE.");
        if(arr_b.length <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Given byte array is of zero length.");
        this.zzgd = arr_b;
    }

    public static AudioBytes from(Message message0) {
        Preconditions.checkNotNull(message0);
        Preconditions.checkArgument(message0.zzl("__audio_bytes"), "Message type \'" + message0.getType() + "\' is not Message.MESSAGE_TYPE_AUDIO_BYTES.");
        return new AudioBytes(message0.getContent());
    }

    public final byte[] getBytes() {
        return this.zzgd;
    }

    public final Message toMessage() {
        return new Message(this.zzgd, "__reserved_namespace", "__audio_bytes");
    }

    @Override
    public final String toString() {
        return "AudioBytes [" + Arrays.toString(this.zzgd) + " ]";
    }
}

