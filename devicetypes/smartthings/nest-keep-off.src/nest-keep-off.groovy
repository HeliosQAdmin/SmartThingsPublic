/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  On/Off Button Tile with water sensor values for Nest OFF using Water Sensor Trigger
 *
 *  Author: BC
 *
 *  Date: 2016-11-21
 */
metadata {
	definition (name: "Nest Keep OFF", namespace: "smartthings", author: "SmartThings") {
		capability "Actuator"
		capability "Switch"
		capability "Water Sensor"
		capability "Sensor"
	}

	// simulator metadata
	simulator {
	}

	// UI tile definitions
	tiles {
		standardTile("button", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "off", label: 'Off', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff", nextState: "off"
			state "on", label: 'On', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821", nextState: "on"
		}
		main "button"
		details "button"
	}
}

def parse(String description) {
}

def on() {
	sendEvent(name: "water", value: "wet")
	sendEvent(name: "switch", value: "on")
}

def off() {
	sendEvent(name: "water", value: "dry")
	sendEvent(name: "switch", value: "off")
}