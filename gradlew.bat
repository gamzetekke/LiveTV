<?xml version="1.0" encoding="UTF-8"?>
<root>
  <item name="android.net.wifi.rtt.RangingRequest.Builder android.net.wifi.rtt.RangingRequest.Builder addAccessPoint(android.net.wifi.ScanResult) 0">
    <annotation name="android.support.annotation.NonNull" />
  </item>
  <item name="android.net.wifi.rtt.RangingRequest.Builder android.net.wifi.rtt.RangingRequest.Builder addAccessPoints(java.util.List&lt;android.net.wifi.ScanResult&gt;) 0">
    <annotation name="android.support.annotation.NonNull" />
  </item>
  <item name="android.net.wifi.rtt.RangingRequest.Builder android.net.wifi.rtt.RangingRequest.Builder addWifiAwarePeer(android.net.MacAddress) 0">
    <annotation name="android.support.annotation.NonNull" />
  </item>
  <item name="android.net.wifi.rtt.RangingRequest.Builder android.net.wifi.rtt.RangingRequest.Builder addWifiAwarePeer(android.net.wifi.aware.PeerHandle) 0">
    <annotation name="android.support.annotation.NonNull" />
  </item>
  <item name="android.net.wifi.rtt.RangingResult android.net.MacAddress getMacAddress()">
    <annotation name="android.support.annotation.Nullable" />
  </item>
  <item name="android.net.wifi.rtt.RangingResult android.net.wifi.aware.PeerHandle getPeerHandle()">
    <annotation name="android.support.annotation.Nullable" />
  </item>
  <item name="android.net.wifi.rtt.RangingResult int getStatus()">
    <annotation name="android.support.annotation.IntDef">
      <val name="value" val="{android.net.wifi.rtt.RangingResult.STATUS_SUCCESS, android.net.wifi.rtt.RangingResult.STATUS_FAIL, android.net.wifi.rtt.RangingResult.STATUS_RESPONDER_DOES_NOT_SUPPORT_IEEE80211MC}" />
    </annotation>
  </item>
  <item name="android.net.wifi.rtt.RangingResultCallback void onRangingFailure(int) 0">
    <annotation name="android.support.annotation.IntDef">
      <val name="value" val="{android.net.wifi.rtt.RangingResultCallback.STATUS_CODE_FAIL, android.net.wifi.rtt.RangingResultCallback.STATUS_CODE_FAIL_RTT_NOT_AVAILABLE}" />
    </annotation>
  </item>
  <item name="android.net.wifi.rtt.RangingResultCallback void onRangingResults(java.util.List&lt;android.net.wifi.rtt.RangingResult&gt;) 0">
    <annotation name="android.support.annotation.NonNull" />
  </item>
  <item name="android.net.wifi.rtt.Wifi