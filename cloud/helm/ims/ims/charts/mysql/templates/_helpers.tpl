{{/*
Expand the name of the chart.
*/}}
{{- define "mysql.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "mysql.fullname" -}}
{{- if .Values.fullnameOverride }}
{{- .Values.fullnameOverride | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- $name := default .Chart.Name .Values.nameOverride }}
{{- if contains $name .Release.Name }}
{{- .Release.Name | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" }}
{{- end }}
{{- end }}
{{- end }}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "mysql.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Common labels
*/}}
{{- define "mysql.labels" -}}
helm.sh/chart: {{ include "mysql.chart" . }}
{{ include "mysql.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{/*
Selector labels
*/}}
{{- define "mysql.selectorLabels" -}}
app.kubernetes.io/name: {{ include "mysql.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}

{{/*
Create the name of the service account to use
*/}}
{{- define "mysql.serviceAccountName" -}}
{{- if .Values.serviceAccount.create }}
{{- default (include "mysql.fullname" .) .Values.serviceAccount.name }}
{{- else }}
{{- default "default" .Values.serviceAccount.name }}
{{- end }}
{{- end }}

{{/*
MySQL selector
*/}}
{{- define "mysql.selector" -}}
app: {{ template "mysql.name" . }}
{{- end -}}


{{/*
headlessService name
*/}}
{{- define "mysql.hs.name" -}}
{{- printf "%s-%s" .Release.Name .Values.headlessService.name | trunc 63 | trimSuffix "-"  }}
{{- end }}

{{/*
headlessService selector
*/}}
{{- define "mysql.ss.selector" -}}
app: {{ template "mysql.hs.name" . }}
{{- end -}}


{{/*
externalService name
*/}}
{{- define "mysql.es.name" -}}
{{- printf "%s-%s" .Release.Name .Values.externalService.name | trunc 63 | trimSuffix "-"  | quote }}
{{- end }}

{{/*
Return mysql secret name
*/}}
{{- define "mysql.secret.name" -}}
{{- printf "%s-%s-%s" .Chart.Name .Values.nameOverride .Values.secret.name | trunc 63 | trimSuffix "-"  | quote }}
{{- end }}

{{/*
Return mysql password
*/}}
{{- define "mysql.password" -}}
{{- if and  .Values.global .Values.global.mysql .Values.global.mysql.password  }}
    {{- .Values.global.mysql.password -}}
{{- else if not (empty .Values.secret.password) -}}
    {{- .Values.secret.password -}}
{{- else -}}
    {{- randAlphaNum 10 -}}
{{- end -}}
{{- end -}}


{{/*
Return mysql configMap name
*/}}
{{- define "mysql.configMap.name" -}}
{{- printf "%s-%s" .Chart.Name .Values.configMap.name | trunc 63 | trimSuffix "-"  | quote }}
{{- end }}

{{/*
Return mysql configMap for script name
*/}}
{{- define "mysql.configMap-script.name" -}}
{{- printf "%s-%s-script" .Chart.Name .Values.configMap.name | trunc 63 | trimSuffix "-"  | quote }}
{{- end }}


{{/*
storage class name
*/}}
{{- define "storageClass.name" -}}
{{- $Values := dict "Values" .Values "Chart" (dict "Name" "nfsProvisioner") "Release" .Release -}}
{{ template "nfsProvisioner.scName" $Values }}
{{- end -}}
