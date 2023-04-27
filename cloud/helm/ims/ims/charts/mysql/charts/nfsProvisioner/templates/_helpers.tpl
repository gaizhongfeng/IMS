{{/*
Expand the name of the chart.
*/}}
{{- define "nfsProvisioner.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "nfsProvisioner.fullname" -}}
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
{{- define "nfsProvisioner.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Common labels
*/}}
{{- define "nfsProvisioner.labels" -}}
helm.sh/chart: {{ include "nfsProvisioner.chart" . }}
{{ include "nfsProvisioner.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{/*
Selector labels
*/}}
{{- define "nfsProvisioner.selectorLabels" -}}
app: {{ include "nfsProvisioner.name" . }}
{{- end }}

{{/*
Create the name of the service account to use
*/}}
{{- define "nfsProvisioner.serviceAccountName" -}}
{{- if .Values.serviceAccount.create }}
{{- default (include "nfsProvisioner.fullname" .) .Values.serviceAccount.name }}
{{- else }}
{{- default "default" .Values.serviceAccount.name }}
{{- end }}
{{- end }}

{{/*
Create the name of the clusterRole to use
*/}}
{{- define "nfsProvisioner.cr.fullname" -}}
{{- printf "%s-%s" (include "nfsProvisioner.fullname" .) .Values.rbac.clusterRole.name -}}
{{- end }}


{{/*
Create the name of the clusterRoleBinding to use
*/}}
{{- define "nfsProvisioner.crb.fullname" -}}
{{- printf "%s-%s" (include "nfsProvisioner.fullname" .) .Values.rbac.clusterRoleBinding.name -}}
{{- end }}

{{/*
Create the name of the NFS PROVISIONER to use
*/}}
{{- define "nfsProvisioner.nfsName" -}}
{{ printf "%s%s" (include "nfsProvisioner.name" .) .Values.NFS.name | lower }}
{{- end }}

{{/*
Create the name of the NFS deployment to use
*/}}
{{- define "nfsProvisioner.deployname" -}}
 {{- printf "%s" (include "nfsProvisioner.fullname" .) | replace "-" "" | lower  -}}
{{- end }}

{{/*
Create the name of the NFS StorageClass to use
*/}}
{{- define "nfsProvisioner.scName" -}}
{{ printf "%s%s" (include "nfsProvisioner.name" .) .Values.storage.StorageClass.name | lower }}
{{- end }}
