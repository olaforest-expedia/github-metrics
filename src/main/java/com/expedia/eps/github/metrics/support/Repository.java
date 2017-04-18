package com.expedia.eps.github.metrics.support;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public enum Repository {
    Common("LCT", "eps-booking-common"),
    DataService("EWE", "eps-booking-data-service"),
    E2eTests("EWE", "eps-booking-e2e-tests"),
    RabbitMq("LCT", "eps-booking-rmq"),
    ConfigService("EWE", "eps-booking-config-service"),
    Router("EWE", "eps-booking-router-service"),
    NotificationService("EWE", "eps-booking-notification-service"),
    SpooferService("EWE", "lct-eps-booking-spoofer-service"),
    PolarisBridge("EWE", "eps-booking-polaris-bridge-service"),
    AsyncResponseService("EWE", "eps-booking-async-response-service"),
    DeliveryAgent("EWE", "eps-booking-delivery-agent-service"),
    BnsDeliveryAgent("EWE", "eps-booking-bns-delivery-agent-service");

    private final String owner;
    private final String name;
}
