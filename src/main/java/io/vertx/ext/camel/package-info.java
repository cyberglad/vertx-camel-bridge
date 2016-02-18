/*
 *  Copyright (c) 2011-2015 The original author or authors
 *  ------------------------------------------------------
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *       The Eclipse Public License is available at
 *       http://www.eclipse.org/legal/epl-v10.html
 *
 *       The Apache License v2.0 is available at
 *       http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

/**
 * = Vert.x Camel Bridge
 * :toc: left
 *
 * Apache Camel (http://camel.apache.org) is an open source Java framework that focuses on making integration easier
 * and more accessible to developers. This bridge lets Vert.x applications interact with Camel endpoints:
 *
 * * the application can send messages to Camel.
 * * the application can receive message from Camel.
 *
 * The bridge relies on the Vert.x event bus and associate an event bus address to a Camel endpoint.
 *
 * == Using vertx-camel-bridge
 *
 * To use the Vert.x Camel Bridge, add the following dependency to the _dependencies_ section of your
 * build descriptor:
 *
 * * Maven (in your `pom.xml`):
 *
 * [source,xml,subs="+attributes"]
 * ----
 * <dependency>
 *   <groupId>${maven.groupId}</groupId>
 *   <artifactId>${maven.artifactId}</artifactId>
 *   <version>${maven.version}</version>
 * </dependency>
 * ----
 *
 * * Gradle (in your `build.gradle` file):
 *
 * [source,groovy,subs="+attributes"]
 * ----
 * compile '${maven.groupId}:${maven.artifactId}:${maven.version}'
 * ----
 *
 * == Bridge configuration
 *
 * Before being used, the bridge needs to be configured and started:
 *
 * [source,$lang]
 * ----
 * {@link examples.Examples#example1(io.vertx.core.Vertx)}
 * ----
 *
 * The bridge requires a `CamelContext`. It will find the endpoint from the context.
 *
 * === Inbound mapping
 *
 * Inbound mapping associates a Camel endpoint to an event bus address. Messages received on this endpoint are
 * transformed to event bus messages.
 *
 * [source,$lang]
 * ----
 * {@link examples.Examples#example2(io.vertx.core.Vertx, org.apache.camel.CamelContext)}
 * ----
 *
 * The snippet above shows different ways to configure an inbound mapping:
 *
 * * you can configure the Camel endpoint either using the `Endpoint` object or its uri
 * * you can disables the header copy (Camel message headers are copied to the event bus message)
 * * you can uses `publish` instead of `send` to broadcast the message to all event bus consumers
 * * you can configures the type of the event bus message body. If not set it uses the Camel message payload. If
 * sets, it looks in the Camel context for a converter between the Camel message payload and the desired type.
 *
 * _Note_: `org.fusesource.hawtbuf.Buffer` are automatically converted to {@link io.vertx.core.buffer.Buffer}.
 *
 * === Outbound mapping
 *
 * Outbound mapping associates an event bus address to a Camel endpoint. Messages received on this event bus address
 * are transformed to Camel messages and sent to the endpoint.
 *
 * [source,$lang]
 * ----
 * {@link examples.Examples#example3(io.vertx.core.Vertx, org.apache.camel.CamelContext)}
 * ----
 *
 * The snippet above shows different ways to configure an outbound mapping.
 *
 * You can connect your outbound mapping to a Camel route:
 *
 * [source,$lang]
 * ----
 * {@link examples.Examples#example4(io.vertx.core.Vertx, org.apache.camel.CamelContext)}
 * ----
 *
 * == Stopping the bridge
 *
 * Don't forget to stop the bridge using the `stop` method.
 *
 */
@ModuleGen(name = "vertx-camel-bridge", groupPackage = "io.vertx.ext.camel")
@Document(fileName = "index.ad")
package io.vertx.ext.camel;

import io.vertx.codegen.annotations.ModuleGen;
import io.vertx.docgen.Document;