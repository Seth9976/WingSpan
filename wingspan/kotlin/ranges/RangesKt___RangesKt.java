package kotlin.ranges;

import com.unity3d.player.UnityPlayerActivity;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;

@Metadata(d1 = {"\u0000t\n\u0002\b\u0002\n\u0002\u0010\u000F\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001E\u001A\'\u0010\u0000\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001A\u0002H\u0001\u00A2\u0006\u0002\u0010\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u0005\u001A\u0012\u0010\u0000\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0006\u001A\u0012\u0010\u0000\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u0007\u001A\u0012\u0010\u0000\u001A\u00020\b*\u00020\b2\u0006\u0010\u0003\u001A\u00020\b\u001A\u0012\u0010\u0000\u001A\u00020\t*\u00020\t2\u0006\u0010\u0003\u001A\u00020\t\u001A\u0012\u0010\u0000\u001A\u00020\n*\u00020\n2\u0006\u0010\u0003\u001A\u00020\n\u001A\'\u0010\u000B\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001A\u0002H\u0001\u00A2\u0006\u0002\u0010\u0004\u001A\u0012\u0010\u000B\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005\u001A\u0012\u0010\u000B\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001A\u00020\u0006\u001A\u0012\u0010\u000B\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007\u001A\u0012\u0010\u000B\u001A\u00020\b*\u00020\b2\u0006\u0010\f\u001A\u00020\b\u001A\u0012\u0010\u000B\u001A\u00020\t*\u00020\t2\u0006\u0010\f\u001A\u00020\t\u001A\u0012\u0010\u000B\u001A\u00020\n*\u00020\n2\u0006\u0010\f\u001A\u00020\n\u001A3\u0010\r\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001A\u0004\u0018\u0001H\u00012\b\u0010\f\u001A\u0004\u0018\u0001H\u0001\u00A2\u0006\u0002\u0010\u000E\u001A/\u0010\r\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007\u00A2\u0006\u0002\u0010\u0011\u001A-\u0010\r\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0012\u00A2\u0006\u0002\u0010\u0013\u001A\u001A\u0010\r\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005\u001A\u001A\u0010\r\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u0006\u001A\u001A\u0010\r\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007\u001A\u001A\u0010\r\u001A\u00020\b*\u00020\b2\u0006\u0010\u0003\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\b\u001A\u0018\u0010\r\u001A\u00020\b*\u00020\b2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\b0\u0012\u001A\u001A\u0010\r\u001A\u00020\t*\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\t\u001A\u0018\u0010\r\u001A\u00020\t*\u00020\t2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\t0\u0012\u001A\u001A\u0010\r\u001A\u00020\n*\u00020\n2\u0006\u0010\u0003\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n\u001A\u001C\u0010\u0014\u001A\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0087\n\u00A2\u0006\u0002\u0010\u0019\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001A\u001A\u00020\u0006H\u0087\u0002\u00A2\u0006\u0002\b\u001B\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001A\u001A\u00020\u0007H\u0087\u0002\u00A2\u0006\u0002\b\u001B\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001A\u001A\u00020\bH\u0087\u0002\u00A2\u0006\u0002\b\u001B\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001A\u001A\u00020\tH\u0087\u0002\u00A2\u0006\u0002\b\u001B\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001A\u001A\u00020\nH\u0087\u0002\u00A2\u0006\u0002\b\u001B\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\u0002\u00A2\u0006\u0002\b\u001C\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001A\u001A\u00020\u0007H\u0087\u0002\u00A2\u0006\u0002\b\u001C\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001A\u001A\u00020\bH\u0087\u0002\u00A2\u0006\u0002\b\u001C\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001A\u001A\u00020\tH\u0087\u0002\u00A2\u0006\u0002\b\u001C\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001A\u001A\u00020\nH\u0087\u0002\u00A2\u0006\u0002\b\u001C\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\u0002\u00A2\u0006\u0002\b\u001D\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001A\u001A\u00020\u0006H\u0087\u0002\u00A2\u0006\u0002\b\u001D\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001A\u001A\u00020\bH\u0087\u0002\u00A2\u0006\u0002\b\u001D\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001A\u001A\u00020\tH\u0087\u0002\u00A2\u0006\u0002\b\u001D\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001A\u001A\u00020\nH\u0087\u0002\u00A2\u0006\u0002\b\u001D\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\u0002\u00A2\u0006\u0002\b\u001E\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001A\u001A\u00020\u0006H\u0087\u0002\u00A2\u0006\u0002\b\u001E\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001A\u001A\u00020\u0007H\u0087\u0002\u00A2\u0006\u0002\b\u001E\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001A\u001A\u00020\tH\u0087\u0002\u00A2\u0006\u0002\b\u001E\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001A\u001A\u00020\nH\u0087\u0002\u00A2\u0006\u0002\b\u001E\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\u0002\u00A2\u0006\u0002\b\u001F\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001A\u001A\u00020\u0006H\u0087\u0002\u00A2\u0006\u0002\b\u001F\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001A\u001A\u00020\u0007H\u0087\u0002\u00A2\u0006\u0002\b\u001F\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001A\u001A\u00020\bH\u0087\u0002\u00A2\u0006\u0002\b\u001F\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001A\u001A\u00020\nH\u0087\u0002\u00A2\u0006\u0002\b\u001F\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\u0002\u00A2\u0006\u0002\b \u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001A\u001A\u00020\u0006H\u0087\u0002\u00A2\u0006\u0002\b \u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001A\u001A\u00020\u0007H\u0087\u0002\u00A2\u0006\u0002\b \u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001A\u001A\u00020\bH\u0087\u0002\u00A2\u0006\u0002\b \u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001A\u001A\u00020\tH\u0087\u0002\u00A2\u0006\u0002\b \u001A\u0015\u0010\u0014\u001A\u00020\u0015*\u00020!2\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\n\u001A\u001C\u0010\u0014\u001A\u00020\u0015*\u00020!2\b\u0010\u0017\u001A\u0004\u0018\u00010\bH\u0087\n\u00A2\u0006\u0002\u0010\"\u001A\u0015\u0010\u0014\u001A\u00020\u0015*\u00020!2\u0006\u0010\u001A\u001A\u00020\tH\u0087\n\u001A\u0015\u0010\u0014\u001A\u00020\u0015*\u00020!2\u0006\u0010\u001A\u001A\u00020\nH\u0087\n\u001A\u0015\u0010\u0014\u001A\u00020\u0015*\u00020#2\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\n\u001A\u0015\u0010\u0014\u001A\u00020\u0015*\u00020#2\u0006\u0010\u001A\u001A\u00020\bH\u0087\n\u001A\u001C\u0010\u0014\u001A\u00020\u0015*\u00020#2\b\u0010\u0017\u001A\u0004\u0018\u00010\tH\u0087\n\u00A2\u0006\u0002\u0010$\u001A\u0015\u0010\u0014\u001A\u00020\u0015*\u00020#2\u0006\u0010\u001A\u001A\u00020\nH\u0087\n\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001A\u001A\u00020\bH\u0087\u0002\u00A2\u0006\u0002\b\u001B\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001A\u001A\u00020\tH\u0087\u0002\u00A2\u0006\u0002\b\u001B\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001A\u001A\u00020\nH\u0087\u0002\u00A2\u0006\u0002\b\u001B\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010\u001A\u001A\u00020\u0007H\u0087\u0002\u00A2\u0006\u0002\b\u001C\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\u0002\u00A2\u0006\u0002\b\u001E\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001A\u001A\u00020\tH\u0087\u0002\u00A2\u0006\u0002\b\u001E\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001A\u001A\u00020\nH\u0087\u0002\u00A2\u0006\u0002\b\u001E\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\u0002\u00A2\u0006\u0002\b\u001F\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001A\u001A\u00020\bH\u0087\u0002\u00A2\u0006\u0002\b\u001F\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001A\u001A\u00020\nH\u0087\u0002\u00A2\u0006\u0002\b\u001F\u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001A\u001A\u00020\u0005H\u0087\u0002\u00A2\u0006\u0002\b \u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001A\u001A\u00020\bH\u0087\u0002\u00A2\u0006\u0002\b \u001A \u0010\u0014\u001A\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001A\u001A\u00020\tH\u0087\u0002\u00A2\u0006\u0002\b \u001A\u0015\u0010&\u001A\u00020\'*\u00020\u00052\u0006\u0010(\u001A\u00020\u0005H\u0086\u0004\u001A\u0015\u0010&\u001A\u00020\'*\u00020\u00052\u0006\u0010(\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020)*\u00020\u00052\u0006\u0010(\u001A\u00020\tH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020\'*\u00020\u00052\u0006\u0010(\u001A\u00020\nH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020**\u00020\u00182\u0006\u0010(\u001A\u00020\u0018H\u0086\u0004\u001A\u0015\u0010&\u001A\u00020\'*\u00020\b2\u0006\u0010(\u001A\u00020\u0005H\u0086\u0004\u001A\u0015\u0010&\u001A\u00020\'*\u00020\b2\u0006\u0010(\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020)*\u00020\b2\u0006\u0010(\u001A\u00020\tH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020\'*\u00020\b2\u0006\u0010(\u001A\u00020\nH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020)*\u00020\t2\u0006\u0010(\u001A\u00020\u0005H\u0086\u0004\u001A\u0015\u0010&\u001A\u00020)*\u00020\t2\u0006\u0010(\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020)*\u00020\t2\u0006\u0010(\u001A\u00020\tH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020)*\u00020\t2\u0006\u0010(\u001A\u00020\nH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020\'*\u00020\n2\u0006\u0010(\u001A\u00020\u0005H\u0086\u0004\u001A\u0015\u0010&\u001A\u00020\'*\u00020\n2\u0006\u0010(\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020)*\u00020\n2\u0006\u0010(\u001A\u00020\tH\u0086\u0004\u001A\u0015\u0010&\u001A\u00020\'*\u00020\n2\u0006\u0010(\u001A\u00020\nH\u0086\u0004\u001A\f\u0010+\u001A\u00020\u0018*\u00020*H\u0007\u001A\f\u0010+\u001A\u00020\b*\u00020\'H\u0007\u001A\f\u0010+\u001A\u00020\t*\u00020)H\u0007\u001A\u0013\u0010,\u001A\u0004\u0018\u00010\u0018*\u00020*H\u0007\u00A2\u0006\u0002\u0010-\u001A\u0013\u0010,\u001A\u0004\u0018\u00010\b*\u00020\'H\u0007\u00A2\u0006\u0002\u0010.\u001A\u0013\u0010,\u001A\u0004\u0018\u00010\t*\u00020)H\u0007\u00A2\u0006\u0002\u0010/\u001A\f\u00100\u001A\u00020\u0018*\u00020*H\u0007\u001A\f\u00100\u001A\u00020\b*\u00020\'H\u0007\u001A\f\u00100\u001A\u00020\t*\u00020)H\u0007\u001A\u0013\u00101\u001A\u0004\u0018\u00010\u0018*\u00020*H\u0007\u00A2\u0006\u0002\u0010-\u001A\u0013\u00101\u001A\u0004\u0018\u00010\b*\u00020\'H\u0007\u00A2\u0006\u0002\u0010.\u001A\u0013\u00101\u001A\u0004\u0018\u00010\t*\u00020)H\u0007\u00A2\u0006\u0002\u0010/\u001A\r\u00102\u001A\u00020\u0018*\u00020\u0016H\u0087\b\u001A\u0014\u00102\u001A\u00020\u0018*\u00020\u00162\u0006\u00102\u001A\u000203H\u0007\u001A\r\u00102\u001A\u00020\b*\u00020!H\u0087\b\u001A\u0014\u00102\u001A\u00020\b*\u00020!2\u0006\u00102\u001A\u000203H\u0007\u001A\r\u00102\u001A\u00020\t*\u00020#H\u0087\b\u001A\u0014\u00102\u001A\u00020\t*\u00020#2\u0006\u00102\u001A\u000203H\u0007\u001A\u0014\u00104\u001A\u0004\u0018\u00010\u0018*\u00020\u0016H\u0087\b\u00A2\u0006\u0002\u00105\u001A\u001B\u00104\u001A\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u00102\u001A\u000203H\u0007\u00A2\u0006\u0002\u00106\u001A\u0014\u00104\u001A\u0004\u0018\u00010\b*\u00020!H\u0087\b\u00A2\u0006\u0002\u00107\u001A\u001B\u00104\u001A\u0004\u0018\u00010\b*\u00020!2\u0006\u00102\u001A\u000203H\u0007\u00A2\u0006\u0002\u00108\u001A\u0014\u00104\u001A\u0004\u0018\u00010\t*\u00020#H\u0087\b\u00A2\u0006\u0002\u00109\u001A\u001B\u00104\u001A\u0004\u0018\u00010\t*\u00020#2\u0006\u00102\u001A\u000203H\u0007\u00A2\u0006\u0002\u0010:\u001A\u0015\u0010;\u001A\u00020!*\u00020\u00052\u0006\u0010(\u001A\u00020\u0005H\u0087\n\u001A\u0015\u0010;\u001A\u00020!*\u00020\u00052\u0006\u0010(\u001A\u00020\bH\u0087\n\u001A\u0015\u0010;\u001A\u00020#*\u00020\u00052\u0006\u0010(\u001A\u00020\tH\u0087\n\u001A\u0015\u0010;\u001A\u00020!*\u00020\u00052\u0006\u0010(\u001A\u00020\nH\u0087\n\u001A\u0015\u0010;\u001A\u00020\u0016*\u00020\u00182\u0006\u0010(\u001A\u00020\u0018H\u0087\n\u001A\u0015\u0010;\u001A\u00020!*\u00020\b2\u0006\u0010(\u001A\u00020\u0005H\u0087\n\u001A\u0015\u0010;\u001A\u00020!*\u00020\b2\u0006\u0010(\u001A\u00020\bH\u0087\n\u001A\u0015\u0010;\u001A\u00020#*\u00020\b2\u0006\u0010(\u001A\u00020\tH\u0087\n\u001A\u0015\u0010;\u001A\u00020!*\u00020\b2\u0006\u0010(\u001A\u00020\nH\u0087\n\u001A\u0015\u0010;\u001A\u00020#*\u00020\t2\u0006\u0010(\u001A\u00020\u0005H\u0087\n\u001A\u0015\u0010;\u001A\u00020#*\u00020\t2\u0006\u0010(\u001A\u00020\bH\u0087\n\u001A\u0015\u0010;\u001A\u00020#*\u00020\t2\u0006\u0010(\u001A\u00020\tH\u0087\n\u001A\u0015\u0010;\u001A\u00020#*\u00020\t2\u0006\u0010(\u001A\u00020\nH\u0087\n\u001A\u0015\u0010;\u001A\u00020!*\u00020\n2\u0006\u0010(\u001A\u00020\u0005H\u0087\n\u001A\u0015\u0010;\u001A\u00020!*\u00020\n2\u0006\u0010(\u001A\u00020\bH\u0087\n\u001A\u0015\u0010;\u001A\u00020#*\u00020\n2\u0006\u0010(\u001A\u00020\tH\u0087\n\u001A\u0015\u0010;\u001A\u00020!*\u00020\n2\u0006\u0010(\u001A\u00020\nH\u0087\n\u001A\n\u0010<\u001A\u00020**\u00020*\u001A\n\u0010<\u001A\u00020\'*\u00020\'\u001A\n\u0010<\u001A\u00020)*\u00020)\u001A\u0015\u0010=\u001A\u00020**\u00020*2\u0006\u0010=\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010=\u001A\u00020\'*\u00020\'2\u0006\u0010=\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010=\u001A\u00020)*\u00020)2\u0006\u0010=\u001A\u00020\tH\u0086\u0004\u001A\u0013\u0010>\u001A\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000\u00A2\u0006\u0002\u0010?\u001A\u0013\u0010>\u001A\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000\u00A2\u0006\u0002\u0010@\u001A\u0013\u0010>\u001A\u0004\u0018\u00010\u0005*\u00020\bH\u0000\u00A2\u0006\u0002\u0010A\u001A\u0013\u0010>\u001A\u0004\u0018\u00010\u0005*\u00020\tH\u0000\u00A2\u0006\u0002\u0010B\u001A\u0013\u0010>\u001A\u0004\u0018\u00010\u0005*\u00020\nH\u0000\u00A2\u0006\u0002\u0010C\u001A\u0013\u0010D\u001A\u0004\u0018\u00010\b*\u00020\u0006H\u0000\u00A2\u0006\u0002\u0010E\u001A\u0013\u0010D\u001A\u0004\u0018\u00010\b*\u00020\u0007H\u0000\u00A2\u0006\u0002\u0010F\u001A\u0013\u0010D\u001A\u0004\u0018\u00010\b*\u00020\tH\u0000\u00A2\u0006\u0002\u0010G\u001A\u0013\u0010H\u001A\u0004\u0018\u00010\t*\u00020\u0006H\u0000\u00A2\u0006\u0002\u0010I\u001A\u0013\u0010H\u001A\u0004\u0018\u00010\t*\u00020\u0007H\u0000\u00A2\u0006\u0002\u0010J\u001A\u0013\u0010K\u001A\u0004\u0018\u00010\n*\u00020\u0006H\u0000\u00A2\u0006\u0002\u0010L\u001A\u0013\u0010K\u001A\u0004\u0018\u00010\n*\u00020\u0007H\u0000\u00A2\u0006\u0002\u0010M\u001A\u0013\u0010K\u001A\u0004\u0018\u00010\n*\u00020\bH\u0000\u00A2\u0006\u0002\u0010N\u001A\u0013\u0010K\u001A\u0004\u0018\u00010\n*\u00020\tH\u0000\u00A2\u0006\u0002\u0010O\u001A\u0015\u0010P\u001A\u00020!*\u00020\u00052\u0006\u0010(\u001A\u00020\u0005H\u0086\u0004\u001A\u0015\u0010P\u001A\u00020!*\u00020\u00052\u0006\u0010(\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020#*\u00020\u00052\u0006\u0010(\u001A\u00020\tH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020!*\u00020\u00052\u0006\u0010(\u001A\u00020\nH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020\u0016*\u00020\u00182\u0006\u0010(\u001A\u00020\u0018H\u0086\u0004\u001A\u0015\u0010P\u001A\u00020!*\u00020\b2\u0006\u0010(\u001A\u00020\u0005H\u0086\u0004\u001A\u0015\u0010P\u001A\u00020!*\u00020\b2\u0006\u0010(\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020#*\u00020\b2\u0006\u0010(\u001A\u00020\tH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020!*\u00020\b2\u0006\u0010(\u001A\u00020\nH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020#*\u00020\t2\u0006\u0010(\u001A\u00020\u0005H\u0086\u0004\u001A\u0015\u0010P\u001A\u00020#*\u00020\t2\u0006\u0010(\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020#*\u00020\t2\u0006\u0010(\u001A\u00020\tH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020#*\u00020\t2\u0006\u0010(\u001A\u00020\nH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020!*\u00020\n2\u0006\u0010(\u001A\u00020\u0005H\u0086\u0004\u001A\u0015\u0010P\u001A\u00020!*\u00020\n2\u0006\u0010(\u001A\u00020\bH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020#*\u00020\n2\u0006\u0010(\u001A\u00020\tH\u0086\u0004\u001A\u0015\u0010P\u001A\u00020!*\u00020\n2\u0006\u0010(\u001A\u00020\nH\u0086\u0004\u00A8\u0006Q"}, d2 = {"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Lkotlin/ranges/OpenEndRange;", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "first", "firstOrNull", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "last", "lastOrNull", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "rangeUntil", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/ranges/RangesKt")
class RangesKt___RangesKt extends RangesKt__RangesKt {
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean byteRangeContains(ClosedRange closedRange0, double f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Byte byte0 = RangesKt.toByteExactOrNull(f);
        return byte0 == null ? false : closedRange0.contains(byte0);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean byteRangeContains(ClosedRange closedRange0, float f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Byte byte0 = RangesKt.toByteExactOrNull(f);
        return byte0 == null ? false : closedRange0.contains(byte0);
    }

    public static final boolean byteRangeContains(ClosedRange closedRange0, int v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Byte byte0 = RangesKt.toByteExactOrNull(v);
        return byte0 == null ? false : closedRange0.contains(byte0);
    }

    public static final boolean byteRangeContains(ClosedRange closedRange0, long v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Byte byte0 = RangesKt.toByteExactOrNull(v);
        return byte0 == null ? false : closedRange0.contains(byte0);
    }

    public static final boolean byteRangeContains(ClosedRange closedRange0, short v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Byte byte0 = RangesKt.toByteExactOrNull(v);
        return byte0 == null ? false : closedRange0.contains(byte0);
    }

    public static final boolean byteRangeContains(OpenEndRange openEndRange0, int v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Byte byte0 = RangesKt.toByteExactOrNull(v);
        return byte0 == null ? false : openEndRange0.contains(byte0);
    }

    public static final boolean byteRangeContains(OpenEndRange openEndRange0, long v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Byte byte0 = RangesKt.toByteExactOrNull(v);
        return byte0 == null ? false : openEndRange0.contains(byte0);
    }

    public static final boolean byteRangeContains(OpenEndRange openEndRange0, short v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Byte byte0 = RangesKt.toByteExactOrNull(v);
        return byte0 == null ? false : openEndRange0.contains(byte0);
    }

    public static final byte coerceAtLeast(byte b, byte b1) {
        return b >= b1 ? b : b1;
    }

    public static final double coerceAtLeast(double f, double f1) {
        return f < f1 ? f1 : f;
    }

    public static final float coerceAtLeast(float f, float f1) {
        return f < f1 ? f1 : f;
    }

    public static final int coerceAtLeast(int v, int v1) {
        return v >= v1 ? v : v1;
    }

    public static final long coerceAtLeast(long v, long v1) {
        return v >= v1 ? v : v1;
    }

    public static final Comparable coerceAtLeast(Comparable comparable0, Comparable comparable1) {
        Intrinsics.checkNotNullParameter(comparable0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(comparable1, UnityPlayerActivity.adjustValue("0319030803140A3313020508"));
        return comparable0.compareTo(comparable1) >= 0 ? comparable0 : comparable1;
    }

    public static final short coerceAtLeast(short v, short v1) {
        return v >= v1 ? v : v1;
    }

    public static final byte coerceAtMost(byte b, byte b1) {
        return b <= b1 ? b : b1;
    }

    public static final double coerceAtMost(double f, double f1) {
        return f > f1 ? f1 : f;
    }

    public static final float coerceAtMost(float f, float f1) {
        return f > f1 ? f1 : f;
    }

    public static final int coerceAtMost(int v, int v1) {
        return v <= v1 ? v : v1;
    }

    public static final long coerceAtMost(long v, long v1) {
        return v <= v1 ? v : v1;
    }

    public static final Comparable coerceAtMost(Comparable comparable0, Comparable comparable1) {
        Intrinsics.checkNotNullParameter(comparable0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(comparable1, UnityPlayerActivity.adjustValue("0311150803140A3313020508"));
        return comparable0.compareTo(comparable1) <= 0 ? comparable0 : comparable1;
    }

    public static final short coerceAtMost(short v, short v1) {
        return v <= v1 ? v : v1;
    }

    public static final byte coerceIn(byte b, byte b1, byte b2) {
        if(b1 > b2) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D0C0F190E08070350") + ((int)b2) + UnityPlayerActivity.adjustValue("4E191E4102041416521A180C0F4E0C0E0B1B03050041") + ((int)b1) + '.');
        }
        if(b < b1) {
            return b1;
        }
        return b <= b2 ? b : b2;
    }

    public static final double coerceIn(double f, double f1, double f2) {
        if(f1 > f2) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D0C0F190E08070350") + f2 + UnityPlayerActivity.adjustValue("4E191E4102041416521A180C0F4E0C0E0B1B03050041") + f1 + '.');
        }
        if(f < f1) {
            return f1;
        }
        return f > f2 ? f2 : f;
    }

    public static final float coerceIn(float f, float f1, float f2) {
        if(f1 > f2) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D0C0F190E08070350") + f2 + UnityPlayerActivity.adjustValue("4E191E4102041416521A180C0F4E0C0E0B1B03050041") + f1 + '.');
        }
        if(f < f1) {
            return f1;
        }
        return f > f2 ? f2 : f;
    }

    public static final int coerceIn(int v, int v1, int v2) {
        if(v1 > v2) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D0C0F190E08070350") + v2 + UnityPlayerActivity.adjustValue("4E191E4102041416521A180C0F4E0C0E0B1B03050041") + v1 + '.');
        }
        if(v < v1) {
            return v1;
        }
        return v <= v2 ? v : v2;
    }

    public static final int coerceIn(int v, ClosedRange closedRange0) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("1C1103060B"));
        if(closedRange0 instanceof ClosedFloatingPointRange) {
            return ((Number)RangesKt.coerceIn(v, ((ClosedFloatingPointRange)closedRange0))).intValue();
        }
        if(closedRange0.isEmpty()) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D") + closedRange0 + '.');
        }
        if(v < ((Number)closedRange0.getStart()).intValue()) {
            return ((Number)closedRange0.getStart()).intValue();
        }
        return v <= ((Number)closedRange0.getEndInclusive()).intValue() ? v : ((Number)closedRange0.getEndInclusive()).intValue();
    }

    public static final long coerceIn(long v, long v1, long v2) {
        if(v1 > v2) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D0C0F190E08070350") + v2 + UnityPlayerActivity.adjustValue("4E191E4102041416521A180C0F4E0C0E0B1B03050041") + v1 + '.');
        }
        if(v < v1) {
            return v1;
        }
        return v <= v2 ? v : v2;
    }

    public static final long coerceIn(long v, ClosedRange closedRange0) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("1C1103060B"));
        if(closedRange0 instanceof ClosedFloatingPointRange) {
            return ((Number)RangesKt.coerceIn(v, ((ClosedFloatingPointRange)closedRange0))).longValue();
        }
        if(closedRange0.isEmpty()) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D") + closedRange0 + '.');
        }
        if(v < ((Number)closedRange0.getStart()).longValue()) {
            return ((Number)closedRange0.getStart()).longValue();
        }
        return v <= ((Number)closedRange0.getEndInclusive()).longValue() ? v : ((Number)closedRange0.getEndInclusive()).longValue();
    }

    public static final Comparable coerceIn(Comparable comparable0, Comparable comparable1, Comparable comparable2) {
        Intrinsics.checkNotNullParameter(comparable0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(comparable1 != null && comparable2 != null) {
            if(comparable1.compareTo(comparable2) > 0) {
                throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D0C0F190E08070350") + comparable2 + UnityPlayerActivity.adjustValue("4E191E4102041416521A180C0F4E0C0E0B1B03050041") + comparable1 + '.');
            }
            if(comparable0.compareTo(comparable1) < 0) {
                return comparable1;
            }
            return comparable0.compareTo(comparable2) <= 0 ? comparable0 : comparable2;
        }
        if(comparable1 != null && comparable0.compareTo(comparable1) < 0) {
            return comparable1;
        }
        return comparable2 == null || comparable0.compareTo(comparable2) <= 0 ? comparable0 : comparable2;
    }

    public static final Comparable coerceIn(Comparable comparable0, ClosedFloatingPointRange closedFloatingPointRange0) {
        Intrinsics.checkNotNullParameter(comparable0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(closedFloatingPointRange0, UnityPlayerActivity.adjustValue("1C1103060B"));
        if(closedFloatingPointRange0.isEmpty()) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D") + closedFloatingPointRange0 + '.');
        }
        if(closedFloatingPointRange0.lessThanOrEquals(comparable0, closedFloatingPointRange0.getStart()) && !closedFloatingPointRange0.lessThanOrEquals(closedFloatingPointRange0.getStart(), comparable0)) {
            return closedFloatingPointRange0.getStart();
        }
        return !closedFloatingPointRange0.lessThanOrEquals(closedFloatingPointRange0.getEndInclusive(), comparable0) || closedFloatingPointRange0.lessThanOrEquals(comparable0, closedFloatingPointRange0.getEndInclusive()) ? comparable0 : closedFloatingPointRange0.getEndInclusive();
    }

    public static final Comparable coerceIn(Comparable comparable0, ClosedRange closedRange0) {
        Intrinsics.checkNotNullParameter(comparable0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("1C1103060B"));
        if(closedRange0 instanceof ClosedFloatingPointRange) {
            return RangesKt.coerceIn(comparable0, ((ClosedFloatingPointRange)closedRange0));
        }
        if(closedRange0.isEmpty()) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D") + closedRange0 + '.');
        }
        if(comparable0.compareTo(closedRange0.getStart()) < 0) {
            return closedRange0.getStart();
        }
        return comparable0.compareTo(closedRange0.getEndInclusive()) <= 0 ? comparable0 : closedRange0.getEndInclusive();
    }

    public static final short coerceIn(short v, short v1, short v2) {
        if(v1 > v2) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D11030F011547061D0B020E044E170609070B50190E4E00094517030019184E13060B150B4A4D0C0F190E08070350") + ((int)v2) + UnityPlayerActivity.adjustValue("4E191E4102041416521A180C0F4E0C0E0B1B03050041") + ((int)v1) + '.');
        }
        if(v < v1) {
            return v1;
        }
        return v <= v2 ? v : v2;
    }

    private static final boolean contains(CharRange charRange0, Character character0) {
        Intrinsics.checkNotNullParameter(charRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return character0 != null && charRange0.contains(character0.charValue());
    }

    private static final boolean contains(IntRange intRange0, byte b) {
        Intrinsics.checkNotNullParameter(intRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.intRangeContains(intRange0, b);
    }

    private static final boolean contains(IntRange intRange0, long v) {
        Intrinsics.checkNotNullParameter(intRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.intRangeContains(intRange0, v);
    }

    private static final boolean contains(IntRange intRange0, Integer integer0) {
        Intrinsics.checkNotNullParameter(intRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return integer0 != null && intRange0.contains(((int)integer0));
    }

    private static final boolean contains(IntRange intRange0, short v) {
        Intrinsics.checkNotNullParameter(intRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.intRangeContains(intRange0, v);
    }

    private static final boolean contains(LongRange longRange0, byte b) {
        Intrinsics.checkNotNullParameter(longRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.longRangeContains(longRange0, b);
    }

    private static final boolean contains(LongRange longRange0, int v) {
        Intrinsics.checkNotNullParameter(longRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.longRangeContains(longRange0, v);
    }

    private static final boolean contains(LongRange longRange0, Long long0) {
        Intrinsics.checkNotNullParameter(longRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return long0 != null && longRange0.contains(((long)long0));
    }

    private static final boolean contains(LongRange longRange0, short v) {
        Intrinsics.checkNotNullParameter(longRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.longRangeContains(longRange0, v);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean doubleRangeContains(ClosedRange closedRange0, byte b) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((double)b));
    }

    public static final boolean doubleRangeContains(ClosedRange closedRange0, float f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((double)f));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean doubleRangeContains(ClosedRange closedRange0, int v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((double)v));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean doubleRangeContains(ClosedRange closedRange0, long v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((double)v));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean doubleRangeContains(ClosedRange closedRange0, short v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((double)v));
    }

    public static final boolean doubleRangeContains(OpenEndRange openEndRange0, float f) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return openEndRange0.contains(((double)f));
    }

    public static final CharProgression downTo(char c, char c1) {
        return CharProgression.Companion.fromClosedRange(c, c1, -1);
    }

    public static final IntProgression downTo(byte b, byte b1) {
        return IntProgression.Companion.fromClosedRange(((int)b), ((int)b1), -1);
    }

    public static final IntProgression downTo(byte b, int v) {
        return IntProgression.Companion.fromClosedRange(((int)b), v, -1);
    }

    public static final IntProgression downTo(byte b, short v) {
        return IntProgression.Companion.fromClosedRange(((int)b), ((int)v), -1);
    }

    public static final IntProgression downTo(int v, byte b) {
        return IntProgression.Companion.fromClosedRange(v, ((int)b), -1);
    }

    public static final IntProgression downTo(int v, int v1) {
        return IntProgression.Companion.fromClosedRange(v, v1, -1);
    }

    public static final IntProgression downTo(int v, short v1) {
        return IntProgression.Companion.fromClosedRange(v, ((int)v1), -1);
    }

    public static final IntProgression downTo(short v, byte b) {
        return IntProgression.Companion.fromClosedRange(((int)v), ((int)b), -1);
    }

    public static final IntProgression downTo(short v, int v1) {
        return IntProgression.Companion.fromClosedRange(((int)v), v1, -1);
    }

    public static final IntProgression downTo(short v, short v1) {
        return IntProgression.Companion.fromClosedRange(((int)v), ((int)v1), -1);
    }

    public static final LongProgression downTo(byte b, long v) {
        return LongProgression.Companion.fromClosedRange(((long)b), v, -1L);
    }

    public static final LongProgression downTo(int v, long v1) {
        return LongProgression.Companion.fromClosedRange(((long)v), v1, -1L);
    }

    public static final LongProgression downTo(long v, byte b) {
        return LongProgression.Companion.fromClosedRange(v, ((long)b), -1L);
    }

    public static final LongProgression downTo(long v, int v1) {
        return LongProgression.Companion.fromClosedRange(v, ((long)v1), -1L);
    }

    public static final LongProgression downTo(long v, long v1) {
        return LongProgression.Companion.fromClosedRange(v, v1, -1L);
    }

    public static final LongProgression downTo(long v, short v1) {
        return LongProgression.Companion.fromClosedRange(v, ((long)v1), -1L);
    }

    public static final LongProgression downTo(short v, long v1) {
        return LongProgression.Companion.fromClosedRange(((long)v), v1, -1L);
    }

    public static final char first(CharProgression charProgression0) {
        Intrinsics.checkNotNullParameter(charProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(charProgression0.isEmpty()) {
            throw new NoSuchElementException(UnityPlayerActivity.adjustValue("3E0202061C0414161B011E4D") + charProgression0 + UnityPlayerActivity.adjustValue("4E191E410B0C17110B40"));
        }
        return charProgression0.getFirst();
    }

    public static final int first(IntProgression intProgression0) {
        Intrinsics.checkNotNullParameter(intProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(intProgression0.isEmpty()) {
            throw new NoSuchElementException(UnityPlayerActivity.adjustValue("3E0202061C0414161B011E4D") + intProgression0 + UnityPlayerActivity.adjustValue("4E191E410B0C17110B40"));
        }
        return intProgression0.getFirst();
    }

    public static final long first(LongProgression longProgression0) {
        Intrinsics.checkNotNullParameter(longProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(longProgression0.isEmpty()) {
            throw new NoSuchElementException(UnityPlayerActivity.adjustValue("3E0202061C0414161B011E4D") + longProgression0 + UnityPlayerActivity.adjustValue("4E191E410B0C17110B40"));
        }
        return longProgression0.getFirst();
    }

    public static final Character firstOrNull(CharProgression charProgression0) {
        Intrinsics.checkNotNullParameter(charProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return charProgression0.isEmpty() ? null : Character.valueOf(charProgression0.getFirst());
    }

    public static final Integer firstOrNull(IntProgression intProgression0) {
        Intrinsics.checkNotNullParameter(intProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return intProgression0.isEmpty() ? null : intProgression0.getFirst();
    }

    public static final Long firstOrNull(LongProgression longProgression0) {
        Intrinsics.checkNotNullParameter(longProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return longProgression0.isEmpty() ? null : longProgression0.getFirst();
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean floatRangeContains(ClosedRange closedRange0, byte b) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((float)b));
    }

    public static final boolean floatRangeContains(ClosedRange closedRange0, double f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((float)f));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean floatRangeContains(ClosedRange closedRange0, int v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((float)v));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean floatRangeContains(ClosedRange closedRange0, long v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((float)v));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean floatRangeContains(ClosedRange closedRange0, short v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((float)v));
    }

    public static final boolean intRangeContains(ClosedRange closedRange0, byte b) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((int)b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean intRangeContains(ClosedRange closedRange0, double f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Integer integer0 = RangesKt.toIntExactOrNull(f);
        return integer0 == null ? false : closedRange0.contains(integer0);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean intRangeContains(ClosedRange closedRange0, float f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Integer integer0 = RangesKt.toIntExactOrNull(f);
        return integer0 == null ? false : closedRange0.contains(integer0);
    }

    public static final boolean intRangeContains(ClosedRange closedRange0, long v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Integer integer0 = RangesKt.toIntExactOrNull(v);
        return integer0 == null ? false : closedRange0.contains(integer0);
    }

    public static final boolean intRangeContains(ClosedRange closedRange0, short v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((int)v));
    }

    public static final boolean intRangeContains(OpenEndRange openEndRange0, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return openEndRange0.contains(((int)b));
    }

    public static final boolean intRangeContains(OpenEndRange openEndRange0, long v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Integer integer0 = RangesKt.toIntExactOrNull(v);
        return integer0 == null ? false : openEndRange0.contains(integer0);
    }

    public static final boolean intRangeContains(OpenEndRange openEndRange0, short v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return openEndRange0.contains(((int)v));
    }

    public static final char last(CharProgression charProgression0) {
        Intrinsics.checkNotNullParameter(charProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(charProgression0.isEmpty()) {
            throw new NoSuchElementException(UnityPlayerActivity.adjustValue("3E0202061C0414161B011E4D") + charProgression0 + UnityPlayerActivity.adjustValue("4E191E410B0C17110B40"));
        }
        return charProgression0.getLast();
    }

    public static final int last(IntProgression intProgression0) {
        Intrinsics.checkNotNullParameter(intProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(intProgression0.isEmpty()) {
            throw new NoSuchElementException(UnityPlayerActivity.adjustValue("3E0202061C0414161B011E4D") + intProgression0 + UnityPlayerActivity.adjustValue("4E191E410B0C17110B40"));
        }
        return intProgression0.getLast();
    }

    public static final long last(LongProgression longProgression0) {
        Intrinsics.checkNotNullParameter(longProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(longProgression0.isEmpty()) {
            throw new NoSuchElementException(UnityPlayerActivity.adjustValue("3E0202061C0414161B011E4D") + longProgression0 + UnityPlayerActivity.adjustValue("4E191E410B0C17110B40"));
        }
        return longProgression0.getLast();
    }

    public static final Character lastOrNull(CharProgression charProgression0) {
        Intrinsics.checkNotNullParameter(charProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return charProgression0.isEmpty() ? null : Character.valueOf(charProgression0.getLast());
    }

    public static final Integer lastOrNull(IntProgression intProgression0) {
        Intrinsics.checkNotNullParameter(intProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return intProgression0.isEmpty() ? null : intProgression0.getLast();
    }

    public static final Long lastOrNull(LongProgression longProgression0) {
        Intrinsics.checkNotNullParameter(longProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return longProgression0.isEmpty() ? null : longProgression0.getLast();
    }

    public static final boolean longRangeContains(ClosedRange closedRange0, byte b) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((long)b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean longRangeContains(ClosedRange closedRange0, double f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Long long0 = RangesKt.toLongExactOrNull(f);
        return long0 == null ? false : closedRange0.contains(long0);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean longRangeContains(ClosedRange closedRange0, float f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Long long0 = RangesKt.toLongExactOrNull(f);
        return long0 == null ? false : closedRange0.contains(long0);
    }

    public static final boolean longRangeContains(ClosedRange closedRange0, int v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((long)v));
    }

    public static final boolean longRangeContains(ClosedRange closedRange0, short v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((long)v));
    }

    public static final boolean longRangeContains(OpenEndRange openEndRange0, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return openEndRange0.contains(((long)b));
    }

    public static final boolean longRangeContains(OpenEndRange openEndRange0, int v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return openEndRange0.contains(((long)v));
    }

    public static final boolean longRangeContains(OpenEndRange openEndRange0, short v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return openEndRange0.contains(((long)v));
    }

    private static final char random(CharRange charRange0) {
        Intrinsics.checkNotNullParameter(charRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.random(charRange0, Random.Default);
    }

    public static final char random(CharRange charRange0, Random random0) {
        Intrinsics.checkNotNullParameter(charRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(random0, UnityPlayerActivity.adjustValue("1C110305010C"));
        try {
            return (char)random0.nextInt(charRange0.getFirst(), charRange0.getLast() + 1);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw new NoSuchElementException(illegalArgumentException0.getMessage());
        }
    }

    private static final int random(IntRange intRange0) {
        Intrinsics.checkNotNullParameter(intRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.random(intRange0, Random.Default);
    }

    public static final int random(IntRange intRange0, Random random0) {
        Intrinsics.checkNotNullParameter(intRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(random0, UnityPlayerActivity.adjustValue("1C110305010C"));
        try {
            return RandomKt.nextInt(random0, intRange0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw new NoSuchElementException(illegalArgumentException0.getMessage());
        }
    }

    private static final long random(LongRange longRange0) {
        Intrinsics.checkNotNullParameter(longRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.random(longRange0, Random.Default);
    }

    public static final long random(LongRange longRange0, Random random0) {
        Intrinsics.checkNotNullParameter(longRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(random0, UnityPlayerActivity.adjustValue("1C110305010C"));
        try {
            return RandomKt.nextLong(random0, longRange0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw new NoSuchElementException(illegalArgumentException0.getMessage());
        }
    }

    private static final Character randomOrNull(CharRange charRange0) {
        Intrinsics.checkNotNullParameter(charRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.randomOrNull(charRange0, Random.Default);
    }

    public static final Character randomOrNull(CharRange charRange0, Random random0) {
        Intrinsics.checkNotNullParameter(charRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(random0, UnityPlayerActivity.adjustValue("1C110305010C"));
        return charRange0.isEmpty() ? null : Character.valueOf(((char)random0.nextInt(charRange0.getFirst(), charRange0.getLast() + 1)));
    }

    private static final Integer randomOrNull(IntRange intRange0) {
        Intrinsics.checkNotNullParameter(intRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.randomOrNull(intRange0, Random.Default);
    }

    public static final Integer randomOrNull(IntRange intRange0, Random random0) {
        Intrinsics.checkNotNullParameter(intRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(random0, UnityPlayerActivity.adjustValue("1C110305010C"));
        return intRange0.isEmpty() ? null : RandomKt.nextInt(random0, intRange0);
    }

    private static final Long randomOrNull(LongRange longRange0) {
        Intrinsics.checkNotNullParameter(longRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return RangesKt.randomOrNull(longRange0, Random.Default);
    }

    public static final Long randomOrNull(LongRange longRange0, Random random0) {
        Intrinsics.checkNotNullParameter(longRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(random0, UnityPlayerActivity.adjustValue("1C110305010C"));
        return longRange0.isEmpty() ? null : RandomKt.nextLong(random0, longRange0);
    }

    private static final CharRange rangeUntil(char c, char c1) {
        return RangesKt.until(c, c1);
    }

    private static final IntRange rangeUntil(byte b, byte b1) {
        return RangesKt.until(b, b1);
    }

    private static final IntRange rangeUntil(byte b, int v) {
        return RangesKt.until(b, v);
    }

    private static final IntRange rangeUntil(byte b, short v) {
        return RangesKt.until(b, v);
    }

    private static final IntRange rangeUntil(int v, byte b) {
        return RangesKt.until(v, b);
    }

    private static final IntRange rangeUntil(int v, int v1) {
        return RangesKt.until(v, v1);
    }

    private static final IntRange rangeUntil(int v, short v1) {
        return RangesKt.until(v, v1);
    }

    private static final IntRange rangeUntil(short v, byte b) {
        return RangesKt.until(v, b);
    }

    private static final IntRange rangeUntil(short v, int v1) {
        return RangesKt.until(v, v1);
    }

    private static final IntRange rangeUntil(short v, short v1) {
        return RangesKt.until(v, v1);
    }

    private static final LongRange rangeUntil(byte b, long v) {
        return RangesKt.until(b, v);
    }

    private static final LongRange rangeUntil(int v, long v1) {
        return RangesKt.until(v, v1);
    }

    private static final LongRange rangeUntil(long v, byte b) {
        return RangesKt.until(v, b);
    }

    private static final LongRange rangeUntil(long v, int v1) {
        return RangesKt.until(v, v1);
    }

    private static final LongRange rangeUntil(long v, long v1) {
        return RangesKt.until(v, v1);
    }

    private static final LongRange rangeUntil(long v, short v1) {
        return RangesKt.until(v, v1);
    }

    private static final LongRange rangeUntil(short v, long v1) {
        return RangesKt.until(v, v1);
    }

    public static final CharProgression reversed(CharProgression charProgression0) {
        Intrinsics.checkNotNullParameter(charProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return CharProgression.Companion.fromClosedRange(charProgression0.getLast(), charProgression0.getFirst(), -charProgression0.getStep());
    }

    public static final IntProgression reversed(IntProgression intProgression0) {
        Intrinsics.checkNotNullParameter(intProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return IntProgression.Companion.fromClosedRange(intProgression0.getLast(), intProgression0.getFirst(), -intProgression0.getStep());
    }

    public static final LongProgression reversed(LongProgression longProgression0) {
        Intrinsics.checkNotNullParameter(longProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return LongProgression.Companion.fromClosedRange(longProgression0.getLast(), longProgression0.getFirst(), -longProgression0.getStep());
    }

    public static final boolean shortRangeContains(ClosedRange closedRange0, byte b) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return closedRange0.contains(((short)b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean shortRangeContains(ClosedRange closedRange0, double f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Short short0 = RangesKt.toShortExactOrNull(f);
        return short0 == null ? false : closedRange0.contains(short0);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean shortRangeContains(ClosedRange closedRange0, float f) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Short short0 = RangesKt.toShortExactOrNull(f);
        return short0 == null ? false : closedRange0.contains(short0);
    }

    public static final boolean shortRangeContains(ClosedRange closedRange0, int v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Short short0 = RangesKt.toShortExactOrNull(v);
        return short0 == null ? false : closedRange0.contains(short0);
    }

    public static final boolean shortRangeContains(ClosedRange closedRange0, long v) {
        Intrinsics.checkNotNullParameter(closedRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Short short0 = RangesKt.toShortExactOrNull(v);
        return short0 == null ? false : closedRange0.contains(short0);
    }

    public static final boolean shortRangeContains(OpenEndRange openEndRange0, byte b) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return openEndRange0.contains(((short)b));
    }

    public static final boolean shortRangeContains(OpenEndRange openEndRange0, int v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Short short0 = RangesKt.toShortExactOrNull(v);
        return short0 == null ? false : openEndRange0.contains(short0);
    }

    public static final boolean shortRangeContains(OpenEndRange openEndRange0, long v) {
        Intrinsics.checkNotNullParameter(openEndRange0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Short short0 = RangesKt.toShortExactOrNull(v);
        return short0 == null ? false : openEndRange0.contains(short0);
    }

    public static final CharProgression step(CharProgression charProgression0, int v) {
        Intrinsics.checkNotNullParameter(charProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        RangesKt.checkStepIsPositive(v > 0, v);
        Companion charProgression$Companion0 = CharProgression.Companion;
        int v1 = charProgression0.getFirst();
        int v2 = charProgression0.getLast();
        if(charProgression0.getStep() <= 0) {
            v = -v;
        }
        return charProgression$Companion0.fromClosedRange(((char)v1), ((char)v2), v);
    }

    public static final IntProgression step(IntProgression intProgression0, int v) {
        Intrinsics.checkNotNullParameter(intProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        RangesKt.checkStepIsPositive(v > 0, v);
        kotlin.ranges.IntProgression.Companion intProgression$Companion0 = IntProgression.Companion;
        int v1 = intProgression0.getFirst();
        int v2 = intProgression0.getLast();
        if(intProgression0.getStep() <= 0) {
            v = -v;
        }
        return intProgression$Companion0.fromClosedRange(v1, v2, v);
    }

    public static final LongProgression step(LongProgression longProgression0, long v) {
        Intrinsics.checkNotNullParameter(longProgression0, UnityPlayerActivity.adjustValue("520405081D5F"));
        RangesKt.checkStepIsPositive(v > 0L, v);
        kotlin.ranges.LongProgression.Companion longProgression$Companion0 = LongProgression.Companion;
        long v1 = longProgression0.getFirst();
        long v2 = longProgression0.getLast();
        if(longProgression0.getStep() <= 0L) {
            v = -v;
        }
        return longProgression$Companion0.fromClosedRange(v1, v2, v);
    }

    public static final Byte toByteExactOrNull(double f) {
        return Double.compare(-128.0, f) > 0 || f > 127.0 ? null : ((byte)(((int)f)));
    }

    public static final Byte toByteExactOrNull(float f) {
        return Float.compare(-128.0f, f) > 0 || f > 127.0f ? null : ((byte)(((int)f)));
    }

    // 去混淆评级： 低(20)
    public static final Byte toByteExactOrNull(int v) {
        return new IntRange(0xFFFFFF80, 0x7F).contains(v) ? ((byte)v) : null;
    }

    // 去混淆评级： 低(20)
    public static final Byte toByteExactOrNull(long v) {
        return new LongRange(0xFFFFFFFFFFFFFF80L, 0x7FL).contains(v) ? ((byte)(((int)v))) : null;
    }

    // 去混淆评级： 低(20)
    public static final Byte toByteExactOrNull(short v) {
        return RangesKt.intRangeContains(new IntRange(0xFFFFFF80, 0x7F), v) ? ((byte)v) : null;
    }

    public static final Integer toIntExactOrNull(double f) {
        return Double.compare(-2147483648.0, f) > 0 || f > 2147483647.0 ? null : ((int)f);
    }

    public static final Integer toIntExactOrNull(float f) {
        return Float.compare(-2147483648.0f, f) > 0 || f > 2147483648.0f ? null : ((int)f);
    }

    // 去混淆评级： 低(20)
    public static final Integer toIntExactOrNull(long v) {
        return new LongRange(0xFFFFFFFF80000000L, 0x7FFFFFFFL).contains(v) ? ((int)v) : null;
    }

    public static final Long toLongExactOrNull(double f) {
        return Double.compare(-9223372036854776000.0, f) > 0 || f > 9223372036854776000.0 ? null : ((long)f);
    }

    public static final Long toLongExactOrNull(float f) {
        return Float.compare(-9223372036854776000.0f, f) > 0 || f > 9223372036854776000.0f ? null : ((long)f);
    }

    public static final Short toShortExactOrNull(double f) {
        return Double.compare(-32768.0, f) > 0 || f > 32767.0 ? null : ((short)(((int)f)));
    }

    public static final Short toShortExactOrNull(float f) {
        return Float.compare(-32768.0f, f) > 0 || f > 32767.0f ? null : ((short)(((int)f)));
    }

    // 去混淆评级： 低(20)
    public static final Short toShortExactOrNull(int v) {
        return new IntRange(0xFFFF8000, 0x7FFF).contains(v) ? ((short)v) : null;
    }

    // 去混淆评级： 低(20)
    public static final Short toShortExactOrNull(long v) {
        return new LongRange(0xFFFFFFFFFFFF8000L, 0x7FFFL).contains(v) ? ((short)(((int)v))) : null;
    }

    public static final CharRange until(char c, char c1) {
        return Intrinsics.compare(c1, 0) > 0 ? new CharRange(c, ((char)(c1 - 1))) : CharRange.Companion.getEMPTY();
    }

    public static final IntRange until(byte b, byte b1) {
        return new IntRange(((int)b), b1 - 1);
    }

    public static final IntRange until(byte b, int v) {
        return v > 0x80000000 ? new IntRange(((int)b), v - 1) : IntRange.Companion.getEMPTY();
    }

    public static final IntRange until(byte b, short v) {
        return new IntRange(((int)b), v - 1);
    }

    public static final IntRange until(int v, byte b) {
        return new IntRange(v, b - 1);
    }

    public static final IntRange until(int v, int v1) {
        return v1 > 0x80000000 ? new IntRange(v, v1 - 1) : IntRange.Companion.getEMPTY();
    }

    public static final IntRange until(int v, short v1) {
        return new IntRange(v, v1 - 1);
    }

    public static final IntRange until(short v, byte b) {
        return new IntRange(((int)v), b - 1);
    }

    public static final IntRange until(short v, int v1) {
        return v1 > 0x80000000 ? new IntRange(((int)v), v1 - 1) : IntRange.Companion.getEMPTY();
    }

    public static final IntRange until(short v, short v1) {
        return new IntRange(((int)v), v1 - 1);
    }

    public static final LongRange until(byte b, long v) {
        return v > 0x8000000000000000L ? new LongRange(((long)b), v - 1L) : LongRange.Companion.getEMPTY();
    }

    public static final LongRange until(int v, long v1) {
        return v1 > 0x8000000000000000L ? new LongRange(((long)v), v1 - 1L) : LongRange.Companion.getEMPTY();
    }

    public static final LongRange until(long v, byte b) {
        return new LongRange(v, ((long)b) - 1L);
    }

    public static final LongRange until(long v, int v1) {
        return new LongRange(v, ((long)v1) - 1L);
    }

    public static final LongRange until(long v, long v1) {
        return v1 > 0x8000000000000000L ? new LongRange(v, v1 - 1L) : LongRange.Companion.getEMPTY();
    }

    public static final LongRange until(long v, short v1) {
        return new LongRange(v, ((long)v1) - 1L);
    }

    public static final LongRange until(short v, long v1) {
        return v1 > 0x8000000000000000L ? new LongRange(((long)v), v1 - 1L) : LongRange.Companion.getEMPTY();
    }
}

