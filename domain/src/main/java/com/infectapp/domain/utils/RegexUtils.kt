/*
 *  Copyright (c) 2017-present,  Created by Carlos Mateo Benito <apps.carmabs@gmail.com>.
 *
 *  Licensed under the Apache License, VersionModel 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is
 *  distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 */

package com.infectapp.domain.utils

object RegexUtils {
    //TODO Create function for password
    fun isEmail(s: String): Boolean {
        val pattern = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return s.matches(pattern.toRegex())
    }
}