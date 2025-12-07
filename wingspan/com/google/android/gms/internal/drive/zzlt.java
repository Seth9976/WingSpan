package com.google.android.gms.internal.drive;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeSet;

final class zzlt {
    static String zza(zzlq zzlq0, String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("# ");
        stringBuilder0.append(s);
        zzlt.zza(zzlq0, stringBuilder0, 0);
        return stringBuilder0.toString();
    }

    private static void zza(zzlq zzlq0, StringBuilder stringBuilder0, int v) {
        boolean z1;
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        TreeSet treeSet0 = new TreeSet();
        Method[] arr_method = zzlq0.getClass().getDeclaredMethods();
        for(int v1 = 0; v1 < arr_method.length; ++v1) {
            Method method0 = arr_method[v1];
            hashMap1.put(method0.getName(), method0);
            if(method0.getParameterTypes().length == 0) {
                hashMap0.put(method0.getName(), method0);
                if(method0.getName().startsWith("get")) {
                    treeSet0.add(method0.getName());
                }
            }
        }
        for(Object object0: treeSet0) {
            String s = (String)object0;
            String s1 = s.replaceFirst("get", "");
            boolean z = true;
            if(s1.endsWith("List") && !s1.endsWith("OrBuilderList") && !s1.equals("List")) {
                String s2 = s1.substring(0, 1).toLowerCase();
                String s3 = s1.substring(1, s1.length() - 4);
                String s4 = s3.length() == 0 ? new String(s2) : s2 + s3;
                Method method1 = (Method)hashMap0.get(s);
                if(method1 != null && method1.getReturnType().equals(List.class)) {
                    zzlt.zza(stringBuilder0, v, zzlt.zzo(s4), zzkk.zza(method1, zzlq0, new Object[0]));
                    continue;
                }
            }
            if(s1.endsWith("Map") && !s1.equals("Map")) {
                String s5 = s1.substring(0, 1).toLowerCase();
                String s6 = s1.substring(1, s1.length() - 3);
                String s7 = s6.length() == 0 ? new String(s5) : s5 + s6;
                Method method2 = (Method)hashMap0.get(s);
                if(method2 != null && method2.getReturnType().equals(Map.class) && !method2.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method2.getModifiers())) {
                    zzlt.zza(stringBuilder0, v, zzlt.zzo(s7), zzkk.zza(method2, zzlq0, new Object[0]));
                    continue;
                }
            }
            String s8 = String.valueOf(s1);
            if(((Method)hashMap1.get((s8.length() == 0 ? new String("set") : "set" + s8))) == null) {
            }
            else if(s1.endsWith("Bytes")) {
                String s9 = s1.substring(0, s1.length() - 5);
                if(!hashMap0.containsKey((s9.length() == 0 ? new String("get") : "get" + s9))) {
                    goto label_41;
                }
            }
            else {
            label_41:
                String s10 = s1.substring(0, 1).toLowerCase();
                String s11 = s1.substring(1);
                String s12 = s11.length() == 0 ? new String(s10) : s10 + s11;
                String s13 = String.valueOf(s1);
                Method method3 = (Method)hashMap0.get((s13.length() == 0 ? new String("get") : "get" + s13));
                String s14 = String.valueOf(s1);
                Method method4 = (Method)hashMap0.get((s14.length() == 0 ? new String("has") : "has" + s14));
                if(method3 != null) {
                    Object object1 = zzkk.zza(method3, zzlq0, new Object[0]);
                    if(method4 == null) {
                        if(!(object1 instanceof Boolean)) {
                            if(!(object1 instanceof Integer)) {
                                if(!(object1 instanceof Float)) {
                                    if(!(object1 instanceof Double)) {
                                        if(object1 instanceof String) {
                                            z1 = object1.equals("");
                                        }
                                        else if(object1 instanceof zzjc) {
                                            z1 = object1.equals(zzjc.zznq);
                                        }
                                        else if(!(object1 instanceof zzlq)) {
                                            if(object1 instanceof Enum && ((Enum)object1).ordinal() == 0) {
                                                z1 = true;
                                            }
                                        }
                                        else if(object1 == ((zzlq)object1).zzda()) {
                                            z1 = true;
                                        }
                                    }
                                    else if(((double)(((Double)object1))) == 0.0) {
                                        z1 = true;
                                    }
                                }
                                else if(((float)(((Float)object1))) == 0.0f) {
                                    z1 = true;
                                }
                            }
                            else if(((int)(((Integer)object1))) == 0) {
                                z1 = true;
                            }
                        }
                        else if(!((Boolean)object1).booleanValue()) {
                            z1 = true;
                        }
                        else {
                            z1 = false;
                        }
                        if(z1) {
                            z = false;
                        }
                    }
                    else {
                        z = ((Boolean)zzkk.zza(method4, zzlq0, new Object[0])).booleanValue();
                    }
                    if(z) {
                        zzlt.zza(stringBuilder0, v, zzlt.zzo(s12), object1);
                    }
                }
            }
        }
        if(zzlq0 instanceof zzc) {
            Iterator iterator1 = ((zzc)zzlq0).zzrw.iterator();
            if(iterator1.hasNext()) {
                Object object2 = iterator1.next();
                ((Map.Entry)object2).getKey();
                throw new NoSuchMethodError();
            }
        }
        if(((zzkk)zzlq0).zzrq != null) {
            ((zzkk)zzlq0).zzrq.zza(stringBuilder0, v);
        }
    }

    static final void zza(StringBuilder stringBuilder0, int v, String s, Object object0) {
        if(object0 instanceof List) {
            for(Object object1: ((List)object0)) {
                zzlt.zza(stringBuilder0, v, s, object1);
            }
            return;
        }
        if(object0 instanceof Map) {
            for(Object object2: ((Map)object0).entrySet()) {
                zzlt.zza(stringBuilder0, v, s, ((Map.Entry)object2));
            }
            return;
        }
        stringBuilder0.append('\n');
        for(int v2 = 0; v2 < v; ++v2) {
            stringBuilder0.append(' ');
        }
        stringBuilder0.append(s);
        if(object0 instanceof String) {
            stringBuilder0.append(": \"");
            stringBuilder0.append(zzmt.zzc(zzjc.zzk(((String)object0))));
            stringBuilder0.append('\"');
            return;
        }
        if(object0 instanceof zzjc) {
            stringBuilder0.append(": \"");
            stringBuilder0.append(zzmt.zzc(((zzjc)object0)));
            stringBuilder0.append('\"');
            return;
        }
        if(object0 instanceof zzkk) {
            stringBuilder0.append(" {");
            zzlt.zza(((zzkk)object0), stringBuilder0, v + 2);
            stringBuilder0.append("\n");
            for(int v1 = 0; v1 < v; ++v1) {
                stringBuilder0.append(' ');
            }
            stringBuilder0.append("}");
            return;
        }
        if(object0 instanceof Map.Entry) {
            stringBuilder0.append(" {");
            zzlt.zza(stringBuilder0, v + 2, "key", ((Map.Entry)object0).getKey());
            zzlt.zza(stringBuilder0, v + 2, "value", ((Map.Entry)object0).getValue());
            stringBuilder0.append("\n");
            while(v1 < v) {
                stringBuilder0.append(' ');
                ++v1;
            }
            stringBuilder0.append("}");
            return;
        }
        stringBuilder0.append(": ");
        stringBuilder0.append(object0.toString());
    }

    private static final String zzo(String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < s.length(); ++v) {
            int v1 = s.charAt(v);
            if(Character.isUpperCase(((char)v1))) {
                stringBuilder0.append("_");
            }
            stringBuilder0.append(Character.toLowerCase(((char)v1)));
        }
        return stringBuilder0.toString();
    }
}

